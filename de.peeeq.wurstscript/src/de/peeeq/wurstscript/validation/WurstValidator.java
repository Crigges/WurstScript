package de.peeeq.wurstscript.validation;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.jdt.annotation.Nullable;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import de.peeeq.wurstscript.WLogger;
import de.peeeq.wurstscript.ast.*;
import de.peeeq.wurstscript.attributes.CheckHelper;
import de.peeeq.wurstscript.attributes.CofigOverridePackages;
import de.peeeq.wurstscript.attributes.CompileError;
import de.peeeq.wurstscript.attributes.ImplicitFuncs;
import de.peeeq.wurstscript.attributes.names.NameLink;
import de.peeeq.wurstscript.attributes.names.NameLinkType;
import de.peeeq.wurstscript.attributes.names.Visibility;
import de.peeeq.wurstscript.gui.ProgressHelper;
import de.peeeq.wurstscript.jassIm.ImStmts;
import de.peeeq.wurstscript.types.CallSignature;
import de.peeeq.wurstscript.types.FunctionSignature;
import de.peeeq.wurstscript.types.WurstType;
import de.peeeq.wurstscript.types.WurstTypeArray;
import de.peeeq.wurstscript.types.WurstTypeBool;
import de.peeeq.wurstscript.types.WurstTypeClass;
import de.peeeq.wurstscript.types.WurstTypeClosure;
import de.peeeq.wurstscript.types.WurstTypeCode;
import de.peeeq.wurstscript.types.WurstTypeEnum;
import de.peeeq.wurstscript.types.WurstTypeInt;
import de.peeeq.wurstscript.types.WurstTypeInterface;
import de.peeeq.wurstscript.types.WurstTypeModule;
import de.peeeq.wurstscript.types.WurstTypeNamedScope;
import de.peeeq.wurstscript.types.WurstTypeReal;
import de.peeeq.wurstscript.types.WurstTypeString;
import de.peeeq.wurstscript.types.WurstTypeTuple;
import de.peeeq.wurstscript.types.WurstTypeUnknown;
import de.peeeq.wurstscript.types.WurstTypeVoid;
import de.peeeq.wurstscript.utils.Utils;
import de.peeeq.wurstscript.validation.controlflow.DataflowAnomalyAnalysis;
import de.peeeq.wurstscript.validation.controlflow.ReturnsAnalysis;

/**
 * this class validates a wurstscript program
 * 
 * it has visit methods for different elements in the AST and checks whether
 * these are correct
 * 
 * the validation phase might not find all errors, code transformation and
 * optimization phases might detect other errors because they do a more
 * sophisticated analysis of the program
 * 
 * also note that many cases are already caught by the calculation of the
 * attributes
 * 
 */
public class WurstValidator {

	private WurstModel prog;
	private int functionCount;
	private int visitedFunctions;
	private Multimap<WScope	, WScope> calledFunctions = HashMultimap.create();
	private @Nullable AstElement lastElement = null;

	public WurstValidator(WurstModel root) {
		this.prog = root;
	}

	public void validate(List<CompilationUnit> toCheck) {
		try {
			functionCount = countFunctions(); 
			visitedFunctions = 0;
	
			prog.getErrorHandler().setProgress("Checking wurst types", ProgressHelper.getValidatorPercent(visitedFunctions, functionCount));
			for (CompilationUnit cu : toCheck) {
				walkTree(cu);	
			}
			prog.getErrorHandler().setProgress("Post checks", 0.55);
			postChecks(toCheck);
		} catch (RuntimeException e) {
			WLogger.severe(e);
			AstElement le = lastElement;
			if (le != null) {
				le.addError("Encountered compiler bug near element " + Utils.printElement(le) + ":\n" +
						Utils.printException(e));
			} else {
				// rethrow
				throw e;
			}
		}
	}

	/**
	 * checks done after walking the tree
	 * @param toCheck 
	 */
	private void postChecks(List<CompilationUnit> toCheck) {
		checkUnusedImports(toCheck);
	}

	

	private void checkUnusedImports(List<CompilationUnit> toCheck) {
		for (CompilationUnit cu : toCheck) {
			for (WPackage p : cu.getPackages()) {
				checkUnusedImports(p);
			}
		}
	}

	private void checkUnusedImports(WPackage p) {
		Set<WPackage> unused = Sets.newLinkedHashSet();
		// first assume all are unused
		for (WImport imp : p.getImports()) {
			if (!imp.getPackagename().equals("Wurst")) {
				unused.add(imp.attrImportedPackage());
			}
		}
		
		removeUsed(unused, p.getElements());
		
		
		for (WImport imp : p.getImports()) {
			if (imp.attrImportedPackage() != null 
				&& !imp.getIsPublic()
				&& unused.contains(imp.attrImportedPackage()) ) {
				imp.addWarning("The import " + imp.getPackagename() + " is never used directly.");
			}
		}
	}

	private void removeUsed(Set<WPackage> unused, AstElement e) {
		for (int i=0; i<e.size(); i++) {
			removeUsed(unused, e.get(i));
		}
		
		if (e instanceof FuncRef) {
			FuncRef fr = (FuncRef) e;
			FunctionDefinition def = fr.attrFuncDef();
			if (def != null) {
				unused.remove(def.attrNearestPackage());
			}
		}
		if (e instanceof NameRef) {
			NameRef nr = (NameRef) e;
			NameDef def = nr.attrNameDef();
			if (def != null) {
				unused.remove(def.attrNearestPackage());
			}
		}
		if (e instanceof TypeRef) {
			TypeRef t = (TypeRef) e;
			TypeDef def = t.attrTypeDef();
			if (def != null) {
				unused.remove(def.attrNearestPackage());
			}
		}
		if (e instanceof Expr) {
			WurstType typ = ((Expr) e).attrTyp();
			if (typ instanceof WurstTypeNamedScope) {
				WurstTypeNamedScope ns = (WurstTypeNamedScope) typ;
				NamedScope def = ns.getDef();
				if (def != null) {
					unused.remove(def.attrNearestPackage());
				}
			} else if (typ instanceof WurstTypeTuple) {
				TupleDef def = ((WurstTypeTuple) typ).getTupleDef();
				unused.remove(def.attrNearestPackage());
			}
		}
	}

	
	private void walkTree(AstElement e) {
		lastElement = e;
		check(e);
		lastElement = null;
		for (int i=0; i<e.size(); i++) {
			walkTree(e.get(i));
		}
	}

	private void check(AstElement e) {
		try {
			if (e instanceof AstElementWithTypeParameters) checkTypeParameters((AstElementWithTypeParameters) e);
			if (e instanceof AstElementWithNameId) checkName((AstElementWithNameId) e);
			if (e instanceof ClassDef) checkInstanceDef((ClassDef) e);
			if (e instanceof ClassDef) checkOverrides((ClassDef) e);
			if (e instanceof ClassDef) checkConstructorsUnique((ClassDef) e);
			if (e instanceof ClassDef) visit((ClassDef) e);
			if (e instanceof CompilationUnit) checkPackageName((CompilationUnit) e);
			if (e instanceof ConstructorDef) checkConstructor((ConstructorDef) e);
			if (e instanceof ConstructorDef) checkConstructorSuperCall((ConstructorDef) e);
			if (e instanceof ExprBinary) visit((ExprBinary) e);
			if (e instanceof ExprClosure) checkClosure((ExprClosure) e);
			if (e instanceof ExprEmpty) checkExprEmpty((ExprEmpty)e);
			if (e instanceof ExprIntVal) checkIntVal((ExprIntVal) e);
			if (e instanceof ExprFuncRef) checkFuncRef((ExprFuncRef) e);
			if (e instanceof ExprFunctionCall) checkBannedFunctions((ExprFunctionCall) e);
			if (e instanceof ExprFunctionCall) visit((ExprFunctionCall) e);
			if (e instanceof ExprMemberMethod) visit((ExprMemberMethod) e);
			if (e instanceof ExprMemberVar) checkMemberVar((ExprMemberVar) e);
			if (e instanceof ExprMemberArrayVar) checkMemberArrayVar((ExprMemberArrayVar) e);
			if (e instanceof ExprNewObject) checkNewObj((ExprNewObject) e);
			if (e instanceof ExprNewObject) visit((ExprNewObject) e);
			if (e instanceof ExprNull) checkExprNull((ExprNull) e);
			if (e instanceof ExprVarAccess) visit((ExprVarAccess) e);
			if (e instanceof ExprVarArrayAccess) checkArrayAccess((ExprVarArrayAccess) e);
			if (e instanceof ExtensionFuncDef) visit((ExtensionFuncDef) e);
			if (e instanceof FuncDef) visit((FuncDef) e);
			if (e instanceof FuncRef) checkFuncRef((FuncRef) e);
			if (e instanceof FunctionLike) checkUninitializedVars((FunctionLike) e);
			if (e instanceof GlobalVarDef) visit((GlobalVarDef) e);
			if (e instanceof HasModifier) checkModifiers((HasModifier) e);
			if (e instanceof HasTypeArgs) checkTypeBinding((HasTypeArgs) e);
			if (e instanceof InterfaceDef) checkInterfaceDef((InterfaceDef) e);
			if (e instanceof LocalVarDef) checkLocalShadowing((LocalVarDef) e);
			if (e instanceof LocalVarDef) visit((LocalVarDef) e);
			if (e instanceof Modifiers) visit((Modifiers) e);
			if (e instanceof ModuleDef) visit((ModuleDef) e);
			if (e instanceof NameDef) nameDefsMustNotBeNamedAfterJassNativeTypes((NameDef) e);
			if (e instanceof NameDef) checkConfigOverride((NameDef)e);
			if (e instanceof NameRef) checkImplicitParameter((NameRef) e);
			if (e instanceof NameRef) checkNameRef((NameRef) e);
			if (e instanceof StmtCall) checkCall((StmtCall) e); 
			if (e instanceof ExprDestroy) visit((ExprDestroy) e);
			if (e instanceof StmtForRange) checkForRange((StmtForRange) e);
			if (e instanceof StmtIf) visit((StmtIf) e);
			if (e instanceof StmtReturn) visit((StmtReturn) e);
			if (e instanceof StmtSet) checkStmtSet((StmtSet) e);
			if (e instanceof StmtWhile) visit((StmtWhile) e);
			if (e instanceof SwitchStmt) checkSwitch((SwitchStmt) e);
			if (e instanceof TypeExpr) checkTypeExpr((TypeExpr) e);
			if (e instanceof TypeExprArray) chechCodeArrays((TypeExprArray) e);
			if (e instanceof VarDef) checkVarDef((VarDef) e);
			if (e instanceof WImport) visit((WImport) e);
			if (e instanceof WPackage) checkPackage((WPackage) e);
			if (e instanceof WParameter) checkParameter((WParameter) e);
			if (e instanceof WParameter) visit((WParameter) e);
			if (e instanceof WScope) checkForDuplicateNames((WScope) e);
			if (e instanceof WStatement) checkReachability((WStatement) e);
			if (e instanceof WurstModel) checkForDuplicatePackages((WurstModel) e);
			if (e instanceof WStatements) checkForInvalidStmts((WStatements) e);
		} catch (CyclicDependencyError cde) {
			cde.printStackTrace();
			AstElement element = cde.getElement();
			String attr = cde.getAttributeName().replaceFirst("^attr", "");
			throw new CompileError(element.attrSource(), Utils.printElement(element) + " depends on itself when evaluating attribute " + attr);
		}
	}

	private void checkForInvalidStmts(WStatements stmts) {
		for (WStatement s : stmts) {
			if (s instanceof ExprVarAccess) {
				ExprVarAccess ev = (ExprVarAccess) s;
				s.addError("Use of variable " + ev.getVarName() + " is an incomplete statement.");
			}
		}
	}

	private void checkName(AstElementWithNameId e) {
		String name = e.getNameId().getName();
		TypeDef def = e.lookupType(name, false);
		
		if (def != e && def instanceof NativeType) {
			e.addError("The name '" + name + "' is already used as a native type in " + Utils.printPos(def.getSource()));
		} else {
			switch (name) {
			case "int":
			case "integer":
			case "real":
			case "code":
			case "boolean":
			case "string":
			case "handle":
				e.addError("The name '" + name + "' is a built-in type and cannot be used here.");
			}
		}
	}

	private void checkConfigOverride(NameDef e) {
		if (!e.hasAnnotation("@config")) {
			return;
		}
		PackageOrGlobal nearestPackage = e.attrNearestPackage();
		if (!(nearestPackage instanceof WPackage)) {
			e.addError("Annotation @config can only be used in packages.");
			return;
		}
		WPackage configPackage = (WPackage) nearestPackage;
		if (!configPackage.getName().endsWith(CofigOverridePackages.CONFIG_POSTFIX)) {
			e.addError("Annotation @config can only be used in config packages (package name has to end with '_config').");
			return;
		}
		
		WPackage origPackage = CofigOverridePackages.getOriginalPackage(configPackage);
		if (origPackage == null) {
			return;
		}
		
		if (e instanceof GlobalVarDef) {
			GlobalVarDef v = (GlobalVarDef) e;
			NameDef origVar = origPackage.getElements().lookupVarNoConfig(v.getName(), false);
			if (origVar == null) {
				e.addError("Could not find var " + v.getName() + " in configured package.");
				return;
			}
			
			if (!v.attrTyp().equalsType(origVar.attrTyp(), v)) {
				e.addError("Configured variable must have type " + origVar.attrTyp() 
						+ " but the found type is " + v.attrTyp() + ".");
				return;
			}
			
			if (!origVar.hasAnnotation("@configurable")) {
				e.addWarning("The configured variable " + v.getName() + " is not marked with @configurable.\n" + 
						"It is still possible to configure this var but it is not recommended.");
			}
			
		} else if (e instanceof FuncDef) {
			FuncDef funcDef = (FuncDef) e;
			Collection<NameLink> funcs = origPackage.getElements().lookupFuncsNoConfig(funcDef.getName(), false);
			FuncDef configuredFunc = null;
			for (NameLink nameLink : funcs) {
				if (nameLink.getNameDef() instanceof FuncDef) {
					FuncDef f = (FuncDef) nameLink.getNameDef();
					if (equalSignatures(funcDef, f)) {
						configuredFunc = f;
						break;
					}
				}
			}
			if (configuredFunc == null) {
				funcDef.addError("Could not find a function " + funcDef.getName() + " with the same signature in the configured package.");
			} else {
				if (!configuredFunc.hasAnnotation("@configurable")) {
					e.addWarning("The configured function " + funcDef.getName() + " is not marked with @configurable.\n" + 
							"It is still possible to configure this function but it is not recommended.");
				}
			}
			
			
		} else {
			e.addError("Configuring " + Utils.printElement(e) + " is not supported by Wurst.");
		}
	}

	private boolean equalSignatures(FuncDef f, FuncDef g) {
		if (f.getParameters().size() != g.getParameters().size()) {
			return false;
		}
		if (!f.getReturnTyp().attrTyp().equalsType(g.getReturnTyp().attrTyp(), f)) {
			return false;
		}
		for (int i=0; i<f.getParameters().size(); i++) {
			if (!f.getParameters().get(i).attrTyp().equalsType(g.getParameters().get(i).attrTyp(), f)) {
				return false;
			}
		}
		
		return true;
	}

	private void checkExprEmpty(ExprEmpty e) {
		e.addError("Incomplete expression...");
		
	}

	private void checkMemberArrayVar(ExprMemberArrayVar e) {
		// TODO Auto-generated method stub
		
	}

	private void checkNameRef(NameRef e) {
		if (e.getVarName().isEmpty()) {
			e.addError("Missing variable name.");
		}
	}

	private void checkPackage(WPackage p) {
		checkForDuplicateImports(p);
		p.attrInitDependencies();
	}

	private void checkTypeExpr(TypeExpr e) {
		if (e instanceof TypeExprResolved) {
			return;
		}
		if (e.isModuleUseTypeArg()) {
			return;
		}
		TypeDef typeDef = e.attrTypeDef();
		if (typeDef instanceof TypeParamDef) { // references a type parameter
			TypeParamDef tp = (TypeParamDef) typeDef;
			if (tp.isStructureDefTypeParam()) { // typeParamDef is for structureDef
				if (tp.attrNearestStructureDef() instanceof ModuleDef) {
					// in modules we can also type-params in static contexts
					return;
				}
				
				if (!e.attrIsDynamicContext()) {
					e.addError("Type variables must not be used in static contexts.");
				}
			}
		}
	}

	private void checkClosure(ExprClosure e) {
		if (e.attrExpectedTyp() instanceof WurstTypeCode) {
			// TODO check if no vars are captured
			if (!e.attrCapturedVariables().isEmpty()) {
				for (Entry<AstElement, VarDef> elem : e.attrCapturedVariables().entries()) {
					elem.getKey().addError("Cannot capture local variable '" + elem.getValue().getName() + 
							"' in anonymous function. This is only possible with closures." );
				}
			}
		} else if (e.attrExpectedTyp() instanceof WurstTypeUnknown
				|| e.attrExpectedTyp() instanceof WurstTypeClosure) {
			e.addError("Closures can only be used when a interface or class type is given.");
			
		} else if (!(e.attrExpectedTyp() instanceof WurstTypeClass
				|| e.attrExpectedTyp() instanceof WurstTypeInterface)) {
			e.addError("Closures can only be used when a interface or class type is given, "
					+ "but at this position a " + e.attrExpectedTyp() + " is expected.");
		}
		e.attrCapturedVariables();
		
		if (e.getImplementation() instanceof ExprStatementsBlock) {
			ExprStatementsBlock block = (ExprStatementsBlock) e.getImplementation();
			new DataflowAnomalyAnalysis().execute(block);
		}
		
		if (e.attrExpectedTyp() instanceof WurstTypeClass) {
			WurstTypeClass ct = (WurstTypeClass) e.attrExpectedTyp();
			
			ClassDef cd = ct.getClassDef();
			if (cd.getConstructors().stream().noneMatch(constr -> constr.getParameters().isEmpty())) {
				e.addError("No default constructor for class " + ct + " found, so it cannot be instantiated using an anonymous function.");
			}
		}
		
	}

	private void checkConstructorsUnique(ClassDef c) {
		List<ConstructorDef> constrs = c.getConstructors();
		
		for (int i=0; i<constrs.size()-1; i++) {
			ConstructorDef c1 = constrs.get(i);
			for (int j=i+1; i<constrs.size(); i++) {
				ConstructorDef c2 = constrs.get(j);
				if (c1.getParameters().size() != c2.getParameters().size()) {
					continue;
				}
				
				if (!parametersTypeDisjunct(c1.getParameters(),c2.getParameters())) {
					c2.addError("Duplicate constructor, an other constructor with similar types is already defined in line " + c1.attrSource().getLine());
				}
			}
		}
		
	}


	private boolean parametersTypeDisjunct(WParameters params1,
			WParameters params2) {
		for (int i = 0; i < params1.size(); i++) {
			WurstType t1 = params1.get(i).attrTyp();
			WurstType t2 = params2.get(i).attrTyp();
			if (!t1.isSubtypeOf(t2, params1) && !t2.isSubtypeOf(t1, params2)) {
				return true;
			}
		}
		return false;
	}

	private void checkImplicitParameter(NameRef e) {
		e.attrImplicitParameter();
	}

	private void checkTypeParameters(AstElementWithTypeParameters e) {
		for (TypeParamDef ta : e.getTypeParameters()) {
			if (ta.getName().contains("<") || ta.getName().startsWith("#")) {
				ta.addError("Type parameter must be a simple name ");
			} else {
				checkTypeName(ta, ta.getName());
			}
			ta.attrTyp();
		}
	}

	private void checkExprNull(ExprNull e) {
		if (!Utils.isJassCode(e) && e.attrExpectedTyp() instanceof WurstTypeUnknown) {
			e.addError("Cannot use 'null' constant here because " +
					"the compiler cannot infer which kind of null it is.");
		}
		
	}

	private void checkForRange(StmtForRange e) {
		if (!(e.getLoopVar().attrTyp().isSubtypeOf(WurstTypeInt.instance(), e))) {
			e.getLoopVar().addError("For-loop variable must be int.");
		}
		if (!(e.getTo().attrTyp().isSubtypeOf(WurstTypeInt.instance(), e))) {
			e.getLoopVar().addError("For-loop target must be int.");
		}
		if (!(e.getStep().attrTyp().isSubtypeOf(WurstTypeInt.instance(), e))) {
			e.getLoopVar().addError("For-loop step must be int.");
		}
	}

	private void checkIntVal(ExprIntVal e) {
		// check range? ...
	}

	private int countFunctions() {
		final int functionCount[] = new int[1];
		prog.accept(new WurstModel.DefaultVisitor() {
			
			@Override
			public void visit(FuncDef f) {
				functionCount[0]++;
			}
		});
		return functionCount[0];
	}

	private void checkStmtSet(StmtSet s) {

		NameDef nameDef = s.getUpdatedExpr().attrNameDef();
		if (!(nameDef instanceof VarDef)) {
			if (nameDef == null) {
				s.getUpdatedExpr().addError("Could not find variable " + s.getUpdatedExpr().getVarName() + ".");
			}
			s.getUpdatedExpr().addError("Invalid assignment. This is not a variable, this is a " + Utils.printElement(nameDef));
			return;
		}

		WurstType leftType = s.getUpdatedExpr().attrTyp();
		WurstType rightType = s.getRight().attrTyp();

		checkAssignment(Utils.isJassCode(s), s, leftType, rightType);

		checkIfAssigningToConstant(s.getUpdatedExpr());
		
		checkIfNoEffectAssignment(s);
	}

	private void checkIfNoEffectAssignment(StmtSet s) {
		if (refersToSameVar(s.getUpdatedExpr(), s.getRight())) {
			s.addWarning("The assignment to " + Utils.printElement(s.getUpdatedExpr().attrNameDef()) + "  probably has no effect.");
		}
		
	}

	private boolean refersToSameVar(OptExpr a, OptExpr b) {
		if (a instanceof NoExpr && b instanceof NoExpr) {
			return true;
		}
		if (a instanceof ExprThis && b instanceof ExprThis) {
			return true;
		}
		if (a instanceof NameRef && b instanceof NameRef) {
			NameRef va = (NameRef) a;
			NameRef vb = (NameRef) b;
			if (va.attrNameDef() == vb.attrNameDef()
					&& refersToSameVar(va.attrImplicitParameter(), vb.attrImplicitParameter())) {
				if (va instanceof AstElementWithIndexes && vb instanceof AstElementWithIndexes) {
					AstElementWithIndexes vai = (AstElementWithIndexes) va;
					AstElementWithIndexes vbi = (AstElementWithIndexes) vb;
					
					for (int i=0; i<vai.getIndexes().size() && i <vbi.getIndexes().size(); i++) {
						if (!refersToSameVar(vai.getIndexes().get(i), vbi.getIndexes().get(i))) {
							return false;
						}
					}
				}
				return true;
			}
		}
		return false;
	}

	private void checkIfAssigningToConstant(final NameRef left) {
		left.match(new NameRef.MatcherVoid() {

			@Override
			public void case_ExprVarArrayAccess(ExprVarArrayAccess e) {

			}

			@Override
			public void case_ExprVarAccess(ExprVarAccess e) {
				checkVarNotConstant(left, e.attrNameDef());
			}

			@Override
			public void case_ExprMemberVarDot(ExprMemberVarDot e) {
				if (e.attrNameDef() instanceof WParameter) {
					// we have an assignment to a tuple variable
					// check whether left side is 'this' or a constant variable
					if (e.getLeft() instanceof ExprThis) {
						e.addError("Cannot change 'this'. Tuples are not classes.");
					} else if (e.getLeft() instanceof NameRef) {
						checkIfAssigningToConstant((NameRef) e.getLeft());
					} else {
						e.addError("Ok, so you are trying to assign something to the return value of a function. This wont do nothing. Tuples are not classes.");
					}
				}
				checkVarNotConstant(left, e.attrNameDef());
			}

			@Override
			public void case_ExprMemberArrayVarDot(ExprMemberArrayVarDot e) {

			}

			@Override
			public void case_ExprMemberArrayVarDotDot(ExprMemberArrayVarDotDot e) {
				e.addError("Cannot assign to dot-dot-expression.");
			}

			@Override
			public void case_ExprMemberVarDotDot(ExprMemberVarDotDot e) {
				e.addError("Cannot assign to dot-dot-expression.");
			}
		});
	}

	private void checkVarNotConstant(NameRef left, @Nullable NameDef var) {
		if (var != null && var.attrIsConstant()) {
			left.addError("Cannot assign a new value to constant " + Utils.printElement(var));
		}
	}

	private void checkAssignment(boolean isJassCode, AstElement pos, WurstType leftType, WurstType rightType) {
		if (!rightType.isSubtypeOf(leftType, pos)) {
			if (isJassCode) {
				if (leftType.isSubtypeOf(WurstTypeReal.instance(), pos) && rightType.isSubtypeOf(WurstTypeInt.instance(), pos)) {
					// special case: jass allows to assign an integer to a real
					// variable
					return;
				}
			}
			pos.addError("Cannot assign " + rightType + " to " + leftType);
		}
		if (leftType instanceof WurstTypeNamedScope) {
			WurstTypeNamedScope ns = (WurstTypeNamedScope) leftType;
			if (ns.isStaticRef()) {
				pos.addError("Missing variable name in variable declaration.\n" +
						"Cannot assign to " + leftType);
			}
		}
		if (leftType instanceof WurstTypeArray) {
			pos.addError("Missing array index for assignment to array variable.s");
		}
		if (rightType instanceof WurstTypeVoid) {
			if (pos.attrNearestPackage() instanceof WPackage) {
				WPackage pack = (WPackage) pos.attrNearestPackage();
				if (pack != null && !pack.getName().equals("WurstREPL")) { // allow assigning nothing to a variable in the Repl
					pos.addError("Function or expression returns nothing. Cannot assign nothing to a variable.");
				}
			}
		}
	}

	private void visit(LocalVarDef s) {
		checkVarName(s, false);
		if (s.getInitialExpr() instanceof Expr) {
			Expr initial = (Expr) s.getInitialExpr();
			WurstType leftType = s.attrTyp();
			WurstType rightType = initial.attrTyp();

			checkAssignment(Utils.isJassCode(s), s, leftType, rightType);
		}
		checkIfRead(s);
	}

	private void checkIfRead(VarDef s) {
		if (s.getName().startsWith("_")) {
			// variables starting with an underscore are not read
			// (same convention as in Erlang)
			return;
		}
		if (Utils.isJassCode(s)) {
			return;
		}
		if (s.getParent() instanceof StmtForRange) {
			// it is ok, when the variable of a for-statement is not used
			return;
		}
		WScope f = s.attrNearestScope();
		if (f != null && !f.attrReadVariables().contains(s)) {
			s.addWarning("The " + Utils.printElement(s) + " is never read.");
		}
	}

	private void checkVarName(VarDef s, boolean isConstant) {
		String varName = s.getName(); 
		
		if (!isValidVarnameStart(varName) // first letter not lower case
				&& !Utils.isJassCode(s) // not in jass code
				&& !varName.matches("[A-Z0-9_]+") // not a constant
				) {
			s.addWarning("Variable names should start with a lower case character. (" + varName + ")");
		}
		if (varName.equals("handle")) {
			s.addError("\"handle\" is not a valid variable name");
		}else if (varName.equals("code")) {
			s.addError("\"code\" is not a valid variable name");
		}

	}

	private boolean isValidVarnameStart(String varName) {
		return varName.length() > 0 && Character.isLowerCase(varName.charAt(0))
				|| varName.startsWith("_");
	}

	private void visit(WParameter p) {
		checkVarName(p, false);
		checkIfParameterIsRead(p);
	}

	private void checkIfParameterIsRead(WParameter p) {
		FunctionImplementation f = p.attrNearestFuncDef();
		if (f != null) {
			if (p.getParent().getParent() instanceof ExprClosure) {
				// closures can ignore parameters
				return;
			}
			if (f.attrIsOverride()) {
				// if a function is overridden it is ok to ignore parameters
				return;
			}
			if (f.attrIsAbstract()) {
				// if a function is abstract, then parameter vars are not used
				return;
			}
			if (f.attrHasAnnotation("compiletimenative")) {
				return;
			}
		} else {
			if (p.getParent().getParent() instanceof TupleDef) {
				// ignore tuples
				return;
			}
			if (p.getParent().getParent() instanceof NativeFunc) {
				// ignore native functions
				return;
			}
		}
		
		
		checkIfRead(p);
	}

	private void visit(GlobalVarDef s) {
		checkVarName(s, s.attrIsConstant());
		if (s.getInitialExpr() instanceof Expr) {
			Expr initial = (Expr) s.getInitialExpr();
			WurstType leftType = s.attrTyp();
			WurstType rightType = initial.attrTyp();
			checkAssignment(Utils.isJassCode(s), s, leftType, rightType);
		}


		if (s.attrTyp() instanceof WurstTypeArray && !s.attrIsStatic() && s.attrIsDynamicClassMember()) {
//			s.addError("Array variables must be static.\n" +
//					"Hint: use Lists for dynamic stuff.");
		}
	}

	private void visit(StmtIf stmtIf) {
		WurstType condType = stmtIf.getCond().attrTyp();
		if (!(condType instanceof WurstTypeBool)) {
			stmtIf.getCond().addError("If condition must be a boolean but found " + condType);
		}
	}

	private void visit(StmtWhile stmtWhile) {
		WurstType condType = stmtWhile.getCond().attrTyp();
		if (!(condType instanceof WurstTypeBool)) {
			stmtWhile.getCond().addError("While condition must be a boolean but found " + condType);
		}
	}

	private void visit(ExtensionFuncDef func) {
		checkFunctionName(func);
		func.getExtendedType().attrTyp();
	}

	private void checkFunctionName(FunctionDefinition f) {
		if (!Utils.isJassCode(f)) {
			if (!isValidVarnameStart(f.getName())) {
				f.addWarning("Function names should start with an lower case character.");
			}
		}
	}






	private void checkReturn(FunctionLike func) {
		if (!func.attrHasEmptyBody()) {
			new ReturnsAnalysis().execute(func);
		} else { // no body, check if in interface:
			if (func instanceof FunctionImplementation) {
				FunctionImplementation funcDef = (FunctionImplementation) func;
				if (funcDef.getReturnTyp() instanceof TypeExpr && !(func.attrNearestStructureDef() instanceof InterfaceDef)) {
					func.addError("Function " + funcDef.getName() + " is missing a body. Use the 'skip' statement to define an empty body.");
				}
			}
		}
	}

	private void checkReachability(WStatement s) {
		if (s.getParent() instanceof WStatements) {
			WStatements stmts = (WStatements) s.getParent();
			if (s.attrPreviousStatements().isEmpty()) {
				if (s.attrListIndex() > 0 || !(stmts.getParent() instanceof TranslatedToImFunction
												|| stmts.getParent() instanceof ExprStatementsBlock)) {
					if (Utils.isJassCode(s)) {
						// in jass this is just a warning, because
						// the shitty code emitted by jasshelper sometimes 
						// contains unreachable code
						s.addWarning("unreachable code");
					} else {
						s.addError("unreachable code");
					}
				}
			}
		}
	}

	private void visit(FuncDef func) {
		visitedFunctions++;
		func.getErrorHandler().setProgress(null, ProgressHelper.getValidatorPercent(visitedFunctions, functionCount));

		checkFunctionName(func);

		if (func.attrIsAbstract()) { 
			if (!func.attrHasEmptyBody()) {
				func.addError("Abstract function " + func.getName() + " must not have a body.");
			}
			if (func.attrIsPrivate()) {
				func.addError("Abstract functions must not be private.");
			}
		}
	}


	private void checkUninitializedVars(FunctionLike f) {
		boolean isAbstract = false;
		if (f instanceof FuncDef) {
			FuncDef func = (FuncDef) f;
			if (func.attrIsAbstract()) {
				isAbstract = true;
				if (!func.attrHasEmptyBody()) {
					func.getBody().get(0).addError("The abstract function " + func.getName()
							+ " must not have any statements.");
				}
			}
		}
		if (!isAbstract) { // not abstract
			checkReturn(f);
			if (!Utils.isJassCode(f)) {
				new DataflowAnomalyAnalysis().execute(f);
			}
		}
	}

	private void checkCall(StmtCall call) { 
		String funcName;
		if (call instanceof FunctionCall) {
			funcName = ((FunctionCall) call).getFuncName();
		} else if (call instanceof ExprNewObject) {
			funcName = "constructor";
		} else {
			throw new Error("unhandled case: " + Utils.printElement(call));
		}

		call.attrCallSignature().checkSignatureCompatibility(call.attrFunctionSignature(), funcName, call);
	}

	private void visit(ExprFunctionCall stmtCall) {
		String funcName = stmtCall.getFuncName();
		// calculating the exprType should reveal most errors:
		stmtCall.attrTyp();

		if (stmtCall.attrFuncDef() != null) {
			FunctionDefinition calledFunc = stmtCall.attrFuncDef();
			if (calledFunc.attrIsDynamicClassMember()) {
				if (!stmtCall.attrIsDynamicContext()) {
					stmtCall.addError("Cannot call dynamic function " + funcName  +
							" from static context.");
				}
			}
			if (calledFunc instanceof ExtensionFuncDef) {
				stmtCall.addError("Extension function " + funcName + " must be called with an explicit receiver.\n"
						+ "Try to write this."+funcName+"(...) .");
			}
		}

		// special check for filter & condition:
		if (Utils.oneOf(funcName, "Condition", "Filter")
				&& !stmtCall.getArgs().isEmpty()) {
			Expr firstArg = stmtCall.getArgs().get(0);
			if (firstArg instanceof ExprFuncRef) {
				ExprFuncRef exprFuncRef = (ExprFuncRef) firstArg;
				FunctionDefinition f = exprFuncRef.attrFuncDef();
				if (f != null) {
					if (!(f.getReturnTyp().attrTyp() instanceof WurstTypeBool)) {
						firstArg.addError("Functions passed to Filter or Condition must return boolean.");
					}
				}
			}
		}
		
	}

	//	private void checkParams(AstElement where, List<Expr> args, FunctionDefinition calledFunc) {
	//		if (calledFunc == null) {
	//			return;
	//		}
	//		List<PscriptType> parameterTypes = calledFunc.attrParameterTypes();
	//		checkParams(where, args, parameterTypes);
	//	}

	@Deprecated
	private void checkParams(AstElement where, String preMsg, List<Expr> args, FunctionSignature sig) {
		checkParams(where, preMsg, args, sig.getParamTypes());
	}

	@Deprecated
	private void checkParams(AstElement where, String preMsg, List<Expr> args, List<WurstType> parameterTypes) {
		if (args.size() > parameterTypes.size()) {
			where.addError(preMsg + "Too many parameters.");

		} else if (args.size() < parameterTypes.size()) {
			where.addError(preMsg + "Missing parameters.");
		} else {
			for (int i=0; i<args.size(); i++) {

				WurstType actual = args.get(i).attrTyp();
				WurstType expected = parameterTypes.get(i);
				//				if (expected instanceof AstElementWithTypeArgs)
				if (!actual.isSubtypeOf(expected, where)) {
					args.get(i).addError(preMsg + "Expected " + expected + " as parameter " + (i+1) + " but  found " + actual);
				}
			}
		}
	}

	private void visit(ExprBinary expr) {
		FunctionDefinition def = expr.attrFuncDef();
		if (def != null) {
			FunctionSignature sig = FunctionSignature.forFunctionDefinition(def);
			CallSignature callSig = new CallSignature(expr.getLeft(), Collections.singletonList(expr.getRight()));
			callSig.checkSignatureCompatibility(sig, ""+expr.getOp(), expr);
		}
	}

	private void visit(ExprMemberMethod stmtCall) {
		// calculating the exprType should reveal all errors:
		stmtCall.attrTyp();
	}



	private void visit(ExprNewObject stmtCall) {
		stmtCall.attrTyp();
		stmtCall.attrConstructorDef();
	}

	private void visit(Modifiers modifiers) {
		boolean hasVis = false;
		boolean isStatic = false;
		for (Modifier m : modifiers) {
			if (m instanceof VisibilityModifier) {
				if (hasVis) {
					m.addError("Each element can only have one visibility modifier (public, private, ...)");
				}
				hasVis = true;
			} else if (m instanceof ModStatic) {
				if (isStatic) {
					m.addError("double static? - what r u trying to do?");
				}
				isStatic = true;
			}
		}
	}

	private void visit(StmtReturn s) {
		if (s.attrNearestExprStatementsBlock() != null) {
			ExprStatementsBlock e = s.attrNearestExprStatementsBlock();
			if (e.getReturnStmt() != s) {
				s.addError("Return in a statements block can only be at the end.");
				return;
			}
			if (s.getReturnedObj() instanceof Expr) {
				Expr expr = (Expr) s.getReturnedObj();
				if (expr.attrTyp().isVoid()) {
					s.addError("Cannot return void from statements block.");
				}
			} else {
				s.addError("Cannot have empty return statement in statements block.");
			}
		} else {
			FunctionImplementation func = s.attrNearestFuncDef();
			if (func == null) {
				s.addError("return statements can only be used inside functions");
				return;
			}
			checkReturnInFunc(s, func);
		}
	}

	private void checkReturnInFunc(StmtReturn s, FunctionImplementation func) {
		WurstType returnType = func.getReturnTyp().attrTyp().dynamic();
		if (s.getReturnedObj() instanceof Expr) {
			Expr returned = (Expr) s.getReturnedObj();
			if (returnType.isSubtypeOf(WurstTypeVoid.instance(), s)) {
				s.addError("Cannot return a value from a function which returns nothing");
			} else {
				WurstType returnedType = returned.attrTyp();
				if (!returnedType.isSubtypeOf(returnType, s)) {
					s.addError("Cannot return " + returnedType + ", expected expression of type "
							+ returnType);
				}
			}
		} else { // empty return
			if (!returnType.isSubtypeOf(WurstTypeVoid.instance(), s)) {
				s.addError("Missing return value");
			}
		}
	}

	private void visit(ClassDef classDef) {
		checkTypeName(classDef, classDef.getName());
		if (classDef.isInnerClass() && !classDef.attrIsStatic()) {
			classDef.addError("At the moment only static inner classes are supported.");
		}
	}


	private void checkTypeName(AstElement source, String name) {
		if (!Character.isUpperCase(name.charAt(0))) {
			source.addWarning("Type names should start with upper case characters.");
		}
	}

	private void visit(ModuleDef moduleDef) {
		checkTypeName(moduleDef, moduleDef.getName());
		// calculate all functions to find possible errors
		moduleDef.attrNameLinks();
	}


	private void visit(ExprDestroy stmtDestroy) {
		WurstType typ = stmtDestroy.getDestroyedObj().attrTyp();
		if (typ instanceof WurstTypeModule) {

		} else if (typ instanceof WurstTypeClass) {
			WurstTypeClass c = (WurstTypeClass) typ;
			checkDestroyClass(stmtDestroy, c); 
		} else if (typ instanceof WurstTypeInterface) {
			WurstTypeInterface i = (WurstTypeInterface) typ;
			checkDestroyInterface(stmtDestroy, i);
		} else {
			stmtDestroy.addError("Cannot destroy objects of type " + typ);
			return;
		}
	}

	private void checkDestroyInterface(ExprDestroy stmtDestroy,
			WurstTypeInterface i) {
		if (i.isStaticRef()) {
			stmtDestroy.addError("Cannot destroy interface " + i);
		}
	}

	private void checkDestroyClass(ExprDestroy stmtDestroy, WurstTypeClass c) {
		if (c.isStaticRef()) {
			stmtDestroy.addError("Cannot destroy class " + c);
		}
		calledFunctions.put(stmtDestroy.attrNearestScope(), c.getClassDef().getOnDestroy());
	}

	private void visit(ExprVarAccess e) {
		checkVarRef(e, e.attrIsDynamicContext());
	}



	private void visit(WImport wImport) {
		if (wImport.attrImportedPackage() == null) {
			if (!wImport.getPackagename().equals("NoWurst")) {
				wImport.addError("Could not find imported package " + wImport.getPackagename());
			}
			return;
		}
		if (! wImport.attrImportedPackage().getName().equals("Wurst") 
				&& wImport.attrImportedPackage().getName().equals( wImport.attrNearestNamedScope().getName())) {
			wImport.addError("Packages cannot import themselves");
		}
	}

	/**
	 * check if the nameRef e is accessed correctly
	 * i.e. not using a dynamic variable from a static context
	 * @param e
	 * @param dynamicContext
	 */
	private void checkVarRef(NameRef e, boolean dynamicContext) {
		NameDef def = e.attrNameDef();
		if (def instanceof GlobalVarDef) {
			GlobalVarDef g = (GlobalVarDef) def;
			if (g.attrIsDynamicClassMember() && !dynamicContext) {
				e.addError("Cannot reference dynamic variable " +e.getVarName() + " from static context.");
			}
		}
		if (e.attrTyp() instanceof WurstTypeNamedScope) {
			WurstTypeNamedScope wtns = (WurstTypeNamedScope) e.attrTyp();
			if (wtns.isStaticRef()) {
				if (!isUsedAsReceiverInExprMember(e)) {
					e.addError("Reference to " + e.getVarName() + " cannot be used as an expression.");
				} else if (e.getParent() instanceof ExprMemberMethodDotDot) {
					e.addError("Reference to " + e.getVarName() + " cannot be used with the cascade operator. Only dynamic objects are allowed.");
				}
			}
		}
		
	}

	private boolean isUsedAsReceiverInExprMember(Expr e) {
		boolean result = false;
		if (e.getParent() instanceof ExprMember) {
			ExprMember em = (ExprMember) e.getParent();
			if (em.getLeft() == e) {
				result = true;
			}
		}
		return result;
	}

	private void checkTypeBinding(HasTypeArgs e) {
		for (Entry<TypeParamDef, WurstType> t : e.attrTypeParameterBindings().entrySet()) {
			WurstType typ = t.getValue();
			if (!typ.isTranslatedToInt() && !(e instanceof ModuleUse)) {
				String toIndexFuncName = ImplicitFuncs.toIndexFuncName(typ);
				String fromIndexFuncName = ImplicitFuncs.fromIndexFuncName(typ);
				Collection<NameLink> toIndexFuncs = ImplicitFuncs.findToIndexFuncs(typ, e);
				Collection<NameLink> fromIndexFuncs = ImplicitFuncs.findFromIndexFuncs(typ, e);
				if (toIndexFuncs.isEmpty()) {
					e.addError("Type parameters can only be bound to ints and class types, but " +
						"not to " + typ + ".\n" +
							"You can provide functions " + toIndexFuncName + " and " + fromIndexFuncName + " to use this type " +
									"with generics.");
				} else if (fromIndexFuncs.isEmpty()) {
					e.addError("Could not find function " + fromIndexFuncName 
							+ " which is required to use " + typ + " with generics.");
				} else {
					if (toIndexFuncs.size() > 1) {
						e.addError("There is more than one function named " + toIndexFuncName);
					}
					if (fromIndexFuncs.size() > 1) {
						e.addError("There is more than one function named " + fromIndexFuncName);
					}
					NameDef toIndex = Utils.getFirst(toIndexFuncs).getNameDef();
					if (toIndex instanceof FuncDef) {
						FuncDef toIndexF = (FuncDef) toIndex;
						
						if (toIndexF.getParameters().size() != 1) {
							toIndexF.addError("Must have exactly one parameter");
							
						} else if (!toIndexF.getParameters().get(0).attrTyp().dynamic().equalsType(typ, e)) {
							toIndexF.addError("Parameter must be of type " + typ);
						}
						
						WurstType returnType = toIndexF.getReturnTyp().attrTyp().dynamic();
						if (!returnType.equalsType(WurstTypeInt.instance(), e)) {
							toIndexF.addError("Return type must be of type int "+ " but was " + returnType);
						}
					} else {
						toIndex.addError("This should be a function.");
					}
					
					NameDef fromIndex = Utils.getFirst(fromIndexFuncs).getNameDef();
					if (fromIndex instanceof FuncDef) {
						FuncDef fromIndexF = (FuncDef) fromIndex;
						
						if (fromIndexF.getParameters().size() != 1) {
							fromIndexF.addError("Must have exactly one parameter");
							
						} else if (!fromIndexF.getParameters().get(0).attrTyp().dynamic().equalsType(WurstTypeInt.instance(), e)) {
							fromIndexF.addError("Parameter must be of type int");
						}
						
						
						WurstType returnType = fromIndexF.getReturnTyp().attrTyp().dynamic();
						if (!returnType.equalsType(typ, e)) {
							fromIndexF.addError("Return type must be of type " + typ + " but was " + returnType);
						}
						
						
					} else {
						fromIndex.addError("This should be a function.");
					}
				}
			}
		}
	}

	private void checkFuncRef(FuncRef ref) {
		if (ref.getFuncName().isEmpty()) {
			ref.addError("Missing function name.");
		}
		FunctionDefinition called = ref.attrFuncDef();
		WScope scope = ref.attrNearestFuncDef();
		if (scope == null) {
			scope = ref.attrNearestScope();
		}
		if (!(ref instanceof ExprFuncRef)) { // ExprFuncRef is not a direct call
			calledFunctions.put(scope, called);
		}
	}

	private void checkFuncRef(ExprFuncRef ref) {
		FunctionDefinition called = ref.attrFuncDef();
		if (called == null) {
			return;
		}
		if (ref.attrTyp() instanceof WurstTypeCode) {
			if (called.attrParameterTypesIncludingReceiver().size() > 0) {
				String msg = "Can only use functions without parameters in 'code' function references.";
				if (called.attrIsDynamicClassMember()) {
					msg += "\nNote that " + called.getName() + " is a dynamic function and thus has an implicit parameter 'this'.";
				}
				ref.addError(msg);
			}
		}
	}

	private void checkModifiers(final HasModifier e) {
		for (final Modifier m : e.getModifiers()) {
			final StringBuilder error = new StringBuilder();

			e.match(new HasModifier.MatcherVoid() {

				@Override
				public void case_WParameter(WParameter wParameter) {
					check(ModConstant.class);
				}

				@Override
				public void case_TypeParamDef(TypeParamDef typeParamDef) {
					error.append("Type Parameters must not have modifiers");
				}

				@Override
				public void case_NativeType(NativeType nativeType) {
					check(VisibilityPublic.class);
				}

				@SafeVarargs
				private final void check(Class<? extends Modifier> ...allowed) {
					if (m instanceof WurstDoc) {
						// wurstdoc always allowed
						return;
					}
					boolean isAllowed = false;
					for (Class<? extends Modifier> a : allowed) {
						String modName = m.getClass().getName();
						String allowedName = a.getName();
						if (modName.startsWith(allowedName)) {
							isAllowed  = true;
							break;
						}
					}
					if (!isAllowed) {
						error.append("Modifier " + printMod(m) + " not allowed for " +
								Utils.printElement(e) + ".\n Allowed are the following modifiers: ");
						boolean first = true;
						for (Class<? extends Modifier> c : allowed) {
							if (!first) {
								error.append(", ");
							}
							error.append(printMod(c));
							first = false;
						}
					}
				}

				@Override
				public void case_NativeFunc(NativeFunc nativeFunc) {
					check(VisibilityPublic.class, Annotation.class);
				}

				@Override
				public void case_ModuleInstanciation(ModuleInstanciation moduleInstanciation) {
					check(VisibilityPrivate.class, VisibilityProtected.class);
				}

				@Override
				public void case_ModuleDef(ModuleDef moduleDef) {
					check(VisibilityPublic.class);
				}

				@Override
				public void case_LocalVarDef(LocalVarDef localVarDef) {
					check(ModConstant.class);
				}

				@Override
				public void case_GlobalVarDef(GlobalVarDef g) {
					if (g.attrNearestClassOrModule() != null) {
						check(VisibilityPrivate.class, VisibilityProtected.class,
								ModStatic.class, ModConstant.class, Annotation.class);
					} else {
						check(VisibilityPublic.class, ModConstant.class, Annotation.class);
					}
				}

				@Override
				public void case_FuncDef(FuncDef f) {
					if (f.attrNearestStructureDef() != null) {
						if (f.attrNearestStructureDef() instanceof InterfaceDef) {
							check(VisibilityPrivate.class, VisibilityProtected.class,
									ModAbstract.class, ModOverride.class, Annotation.class);
						} else {
							check(VisibilityPrivate.class, VisibilityProtected.class,
									ModAbstract.class, ModOverride.class, ModStatic.class, Annotation.class);
							if (f.attrNearestStructureDef() instanceof ClassDef) {
								if (f.attrIsStatic() && f.attrIsAbstract()) {
									f.addError("Static functions cannot be abstract.");
								}
							}
						}
					} else {
						check(VisibilityPublic.class, Annotation.class);
					}
				}

				@Override
				public void case_ExtensionFuncDef(ExtensionFuncDef extensionFuncDef) {
					check(VisibilityPublic.class, Annotation.class);
				}

				@Override
				public void case_ConstructorDef(ConstructorDef constructorDef) {
					check(VisibilityPrivate.class);
				}

				@Override
				public void case_ClassDef(ClassDef classDef) {
					check(VisibilityPublic.class, ModAbstract.class, ModStatic.class);
					if (!classDef.isInnerClass() && classDef.attrIsStatic()) {
						classDef.addError("Top-level class " + classDef.getName() + " cannot be static. "
								+ "Only inner classes can be declared static.");
					}
				}

				@Override
				public void case_InterfaceDef(InterfaceDef interfaceDef) {
					check(VisibilityPublic.class);
				}

				@Override
				public void case_TupleDef(TupleDef tupleDef) {
					check(VisibilityPublic.class);
				}

				@Override
				public void case_WPackage(WPackage wPackage) {
					check();
				}

				@Override
				public void case_EnumDef(EnumDef enumDef) {
					check(VisibilityPublic.class);
				}

				@Override
				public void case_EnumMember(EnumMember enumMember) {
					check();
				}

			});
			if (error.length() > 0) {
				if (m.attrSource().getFile().endsWith(".jurst")) {
					// for jurst only add a warning:
					m.addWarning(error.toString());
				} else {
					m.addError(error.toString());
				}
			}
		}
	}

	private static String printMod(Class<? extends Modifier> c) {
		String name = c.getName().toLowerCase();
		name = name.replaceFirst("^.*\\.", "");
		name = name.replaceAll("^(mod|visibility)", "");
		name = name.replaceAll("impl$", "");
		return name;
	}

	private static String printMod(Modifier m) {
		if (m instanceof Annotation) {
			return ((Annotation) m).getAnnotationType();
		}
		return printMod(m.getClass());
	}

	private void checkConstructor(ConstructorDef d) {
		if (d.attrNearestClassOrModule() instanceof ModuleDef) {
			if (d.getParameters().size() > 0) {
				d.getParameters().addError("Module constructors must not have parameters.");
			}
		}
		StructureDef s = d.attrNearestStructureDef();
		if (s instanceof ClassDef) {
			ClassDef c = (ClassDef) s;
			if (c.attrExtendedClass() != null) {
				// check if super constructor is called correctly...
				// TODO check constr.
				ConstructorDef sc = d.attrSuperConstructor();
				if (sc == null) {
					d.addError("No super constructor found.");
				} else {
					List<WurstType> paramTypes = Lists.newArrayList();
					for (WParameter p : sc.getParameters()) {
						paramTypes.add(p.attrTyp());
					}
					checkParams(d, "Incorrect call to super constructor: ",
							d.getSuperArgs(), paramTypes);
				}
			}
		} else {
			if (!d.getSuperArgs().isEmpty()) {
				d.addError("Module constructors cannot have super calls.");
			}
		}
	}

	private void checkInstanceDef(ClassDef classDef) {
		for (WurstTypeInterface interfaceType : classDef.attrImplementedInterfaces()) {
			InterfaceDef interfaceDef = interfaceType.getInterfaceDef();
			Map<TypeParamDef, WurstType> typeParamMapping = interfaceType.getTypeArgBinding();
			// TODO check type mapping

			nextFunction: 
				for (FuncDef i_funcDef : interfaceDef.getMethods()) {
					Collection<NameLink> c_funcDefs = classDef.attrNameLinks().get(i_funcDef.getName());
					for (NameLink nameLink : c_funcDefs) {
						NameDef c_nameDef = nameLink.getNameDef();
						if (c_nameDef instanceof FuncDef) {
							FuncDef c_funcDef = (FuncDef) c_nameDef;

							CheckHelper.checkIfIsRefinement(typeParamMapping, i_funcDef, c_funcDef, "Cannot implement interface because of function ", true);
							continue nextFunction;
						}
					}
					if (i_funcDef.attrHasEmptyBody()) {
						classDef.addError("The class " + classDef.getName() + " must implement the function " +
								i_funcDef.getName() + ".");
					}
				}
		}

		if (!classDef.attrIsAbstract() && classDef.attrExtendedClass() != null) {
			for (Entry<String, NameLink> e : classDef.attrExtendedClass().attrNameLinks().entries()) {
				if (e.getValue() instanceof FuncDef) {
					FuncDef f = (FuncDef) e.getValue().getNameDef();
					if (f.attrIsAbstract()) {
						boolean implemented = false;
						Collection<NameLink> c_funcDefs = classDef.attrNameLinks().get(f.getName());
						for (NameLink c_nameDefLink : c_funcDefs) {
							NameDef c_nameDef = c_nameDefLink.getNameDef();
							if (c_nameDef instanceof FuncDef) {
								FuncDef f2 = (FuncDef) c_nameDef;
								if (!f2.attrIsAbstract()) {
									implemented = true;
								}
							}
						}
						if (!implemented) {
							classDef.addError("Class " + classDef.getName() + " must implement the abstract function " +
									f.getName() + " from class " + f.attrNearestClassDef().getName());
						}
					}
				}
			}
		}
	}

	private void checkArrayAccess( ExprVarArrayAccess ea) {
		for (Expr index : ea.getIndexes()) {
			if (!(index.attrTyp().isSubtypeOf(WurstTypeInt.instance(), ea))) { 
				index.addError("Arrayindices have to be of type int");
			}
		}
	}

	private void checkInterfaceDef(InterfaceDef i) {
		checkTypeName(i, i.getName());
		// TODO check if functions are refinements
		
		i.attrExtendedInterfaces();
	}

	private void checkNewObj(ExprNewObject e) {
		ConstructorDef constr = e.attrConstructorDef();
		if (constr != null) {
			calledFunctions.put(e.attrNearestScope(), constr);
			if (constr.attrNearestClassDef().attrIsAbstract()) {
				e.addError("Cannot create an instance of the abstract class " + constr.attrNearestClassDef().getName());
				return;
			} 
			checkParams(e, "Wrong object creation: ", e.getArgs(), e.attrFunctionSignature());
		}

	}


	private void nameDefsMustNotBeNamedAfterJassNativeTypes(NameDef n) {
		PackageOrGlobal p = n.attrNearestPackage();
		if (p == null) {
			n.addError("Not in package or global: " + n.getName());
			return;
		}
		//		checkIfTypeDefExists(n, p);
		//		if (p instanceof WPackage) {
		//			// check global scope
		//			p = p.getParent().attrNearestPackage();
		//			checkIfTypeDefExists(n, p);
		//		}
	}

	//	private void checkIfTypeDefExists(NameDef n, PackageOrGlobal p) {
	//		if (n instanceof WPackage) {
	//			// TODO check that there is no other package with same name?
	//			return;
	//		}
	//		TypeDef def = p.lookupType(n.getName());
	//		if (def != null) {
	//			n.addError("The definition for "+Utils.printElement(n)+" defines the same name as the type definition " + Utils.printElement(def));
	//		}
	//	}


	private void checkMemberVar(ExprMemberVar e) {
		if (e.getVarName().length() == 0) {
			e.addError("Incomplete member access.");
		} if (e.getParent() instanceof WStatements) {
			e.addError("Incomplete statement.");
		}
	}

	private void checkPackageName(CompilationUnit cu) {
		if (cu.getPackages().size() == 1 && Utils.isWurstFile(cu.getFile())) {
			// only one package in a wurst file
			WPackage p = cu.getPackages().get(0);
			if (!Utils.fileName(cu.getFile()).equals(p.getName()+".wurst")
				&& !Utils.fileName(cu.getFile()).equals(p.getName()+".jurst")) {
				p.addError("The file must have the same name as the package " + p.getName());
			}
		}
	}

	private void checkForDuplicatePackages(WurstModel model) {
		model.attrPackages();
	}

	private void checkBannedFunctions(ExprFunctionCall e) {
		String[] banned = new String[] {"TriggerRegisterVariableEvent" /*, "ExecuteFunc" */};
		for (String name : banned) {
			if (e.getFuncName().equals(name)) {
				e.addError("The function " + name + " is not allowed in Wurst.");
			}
		}
		
		if (e.getFuncName().equals("ExecuteFunc")) {
			// executeFunc can only use constant string arguments
			if (e.getArgs().size() != 1) {
				e.addError("Wrong number of args");
				return;
			}
			if (e.getArgs().get(0) instanceof ExprStringVal) {
				ExprStringVal s = (ExprStringVal) e.getArgs().get(0);
				String exFunc = s.getValS();
				Collection<NameLink> funcs = e.lookupFuncs(exFunc);
				if (funcs.isEmpty()) {
					e.addError("Could not find function " + exFunc + ".");
					return;
				}
				if (funcs.size() > 1) {
					StringBuilder alternatives = new StringBuilder();
					for (NameLink nameLink : funcs) {
						alternatives.append("\n - " + Utils.printElementWithSource(nameLink.getNameDef()));
					}
					e.addError("Ambigious function name: " + exFunc + ". Alternatives are: " + alternatives);
					return;
				}
				NameLink func = Utils.getFirst(funcs);
				if (func.getParameterTypes().size() != 0) {
					e.addError("Function " + exFunc + " must not have any parameters.");
					return; 
				}
			} else {
				e.addError("Wurst does only support ExecuteFunc with a single string as argument.");
			}
		}
	}

	private boolean isViableSwitchtype(Expr expr) {
		WurstType typ = expr.attrTyp();
		if( typ.equalsType(WurstTypeInt.instance(), null) 
				|| typ.equalsType(WurstTypeString.instance(), null) 
				|| (typ instanceof WurstTypeEnum) ) {
			return true;
		} else if (typ instanceof WurstTypeEnum) {
			WurstTypeEnum wte = (WurstTypeEnum) typ;
			return !wte.isStaticRef();

		}else {
			return false;
		}
	}

	private void checkSwitch(SwitchStmt s) {
		if (! isViableSwitchtype(s.getExpr())) {
			s.addError("The type " + s.getExpr().attrTyp() + " is not viable as switchtype.\nViable switchtypes: int, string, enum");
		} else {
			for (SwitchCase c : s.getCases()) {	
				//				if ( i > 0 ) {
				//					for( int j = 0; j<i; j++) {
				//						WLogger.info(">>>>>>>>>>>>>>>>"+c.getExpr());
				//						WLogger.info(">>>>>>>>>>>>>>>>"+s.getCases().get(j).getExpr());
				//						if ( c.getExpr().attrN.equals(s.getCases().get(j).getExpr()) )
				//							c.addError("Case " + j + " and " + i + " are the same.");
				//					}
				//				}
				if( !c.getExpr().attrTyp().isSubtypeOf(s.getExpr().attrTyp(), c)) {
					c.addError("The type " + c.getExpr().attrTyp() + " does not match the switchtype "
							+  s.getExpr().attrTyp() + ".");
				}
			}
		}
		if(s.getExpr().attrTyp() instanceof WurstTypeEnum) {
			WurstTypeEnum wurstTypeEnum = (WurstTypeEnum) s.getExpr().attrTyp();
			if(s.getSwitchDefault() instanceof NoDefaultCase)
				nextMember: for( EnumMember e : wurstTypeEnum.getDef().getMembers()) {
					String name = e.getName();
					for (SwitchCase c : s.getCases()) {		
						if( c.getExpr() instanceof NameRef) {
							NameRef exprVarAccess = (NameRef) c.getExpr();
							if (exprVarAccess.attrNameDef() == e) {
								continue nextMember;
							}
						}
					}
					s.addError("Enum member " + name + " from enum " + wurstTypeEnum.getName() + " not covered in switchstatement and no default found.");
				}

		}
		if (s.getCases().isEmpty()) {
			s.addError("Switch statement without any cases.");
		}
		// TODO check if all cases for switch are covered

	}

	public static void computeFlowAttributes(AstElement node) {
		if (node instanceof WStatement) {
			WStatement s = (WStatement) node;
			s.attrNextStatements();
		}

		// traverse childs
		for (int i =0; i<node.size(); i++) {
			computeFlowAttributes(node.get(i));
		}
	}

	private void chechCodeArrays(TypeExprArray e) {
		if (e.getBase() instanceof TypeExprSimple) {
			TypeExprSimple base = (TypeExprSimple) e.getBase();
			if (base.getTypeName().equals("code")) {
				e.addError("Code arrays are not supported. Try using an array of triggers or conditionfuncs.");
			}

		}
	}

	private void checkOverrides(ClassDef c) {
		int level = c.attrLevel();
		for (String funcName : c.attrNameLinks().keySet()) {
			List<NameLink> funcs = Lists.newArrayList(c.attrNameLinks().get(funcName)); 
			keepFunctions(funcs);
			sortByLevel(funcs);

			Multimap<NameLink, NameLink> overridesMap = calcOverrides(funcs);
			Multimap<NameLink, NameLink> overriddenByMap = Utils.inverse(overridesMap);

			for (NameLink link : funcs) {
				FuncDef func = (FuncDef) link.getNameDef();
				if (func.attrIsAbstract() && !(c.attrIsAbstract())) {
					boolean implExists = false;
					for (NameLink link2 : overriddenByMap.get(link)) {
						FuncDef func2 = (FuncDef) link2.getNameDef();
						
						if (func.attrIsStatic() && !func2.attrIsStatic()) {
							func2.addError("Cannot override static function with nonstatic function.");
						} else if (!func.attrIsStatic() && func2.attrIsStatic()) {
							func2.addError("Cannot override nonstatic function with static function.");
						}
						
						if (!func2.attrIsAbstract()) {
							implExists = true;
							break;
						}
					}
					if (!implExists) {
						if (c == func.attrNearestStructureDef()) {
							func.addError("Class " + c.getName() + " is not abstract so it cannot have abstract functions like " + func.getName() + ".");
						} else {
							c.addError("Class " + c.getName() + " must implement the abstract function " +
									func.getName() + " from " + Utils.printElement(func.attrNearestStructureDef()));
						}
					}
				}

				if (link.getLevel() < level) {
					// only check functions from current level
					continue;
				}

				if (func.attrIsOverride()) {
					if (overridesMap.get(link).size() == 0) {
						func.addError("Function " + func.getName() + " uses override modifier but overrides nothing.");
					}
					for (NameLink overriden : overridesMap.get(link)) {
						if (overriden.getDefinedIn() instanceof ClassDef 
								&& overriden.getNameDef() instanceof FuncDef) {
							FuncDef overriddenFunc = (FuncDef) overriden.getNameDef();
							if (overriddenFunc.attrIsStatic()) {
								func.addError("Cannot override static function from classes.");
							}
							if (func.attrIsStatic() && !overriddenFunc.attrIsStatic()) {
								func.addError("Cannot override nonstatic function " + func.getName() + " with a static function.");
							}
							if (!func.attrIsStatic() && overriddenFunc.attrIsStatic()) {
								func.addError("Cannot override static function " + func.getName() + " with a nonstatic function.");
							}
						}
					}
				} else {
					for (NameLink overriden : overridesMap.get(link)) {
						if (overriden.getDefinedIn() == link.getDefinedIn()) {
							func.addError("A function with name " + func.getName() + " is already defined " +
									"and the two functions can not be disambiguated using overloading.");
							break;
						} else if (!(overriden.getDefinedIn() instanceof InterfaceDef)) {
							func.addError("Function " + func.getName() + " needs the 'override' modifier.");
							break;
						}
					}
				}

			}


		}
	}


	private Multimap<NameLink, NameLink> calcOverrides(List<NameLink> funcs) {
		Multimap<NameLink, NameLink> overridesMap = HashMultimap.create();

		for (NameLink link1 : funcs) {
			for (NameLink link2 : funcs) {
				if (link1 == link2) {
					continue;
				}
				if (canOverride(link1, link2)) {
					overridesMap.put(link1, link2);
				}

			}
		}
		return overridesMap;
	}

	/**
	 * checks if func1 can override func2 
	 */
	public static boolean canOverride(NameLink func1, NameLink func2) {
		if (func1.getParameterTypes().size() != func2.getParameterTypes().size()) {
			return false;
		}
		
		// contravariant parametertypes
		for (int i=0; i<func1.getParameterTypes().size(); i++) {
			if (!func1.getParameterTypes().get(i)
					.isSupertypeOf(
							func2.getParameterTypes().get(i), func1.getNameDef())) {
				return false;
			}
		}
		// covariant return types
		if (!func1.getReturnType().isSubtypeOf(func2.getReturnType(), func1.getNameDef())) {
			return false;
		}
		return true;
	}
	
	/**
	 * only keep functions and remove everything else from the list
	 * also removes private methods from other scopes 
	 */
	private void keepFunctions(List<NameLink> funcs) {
		Iterator<NameLink> it = funcs.iterator();
		while (it.hasNext()) {
			NameLink func = it.next();
			if (!(func.getNameDef() instanceof FuncDef)
					|| func.getVisibility() == Visibility.PRIVATE_OTHER) {
				it.remove();
			}
		}
	}

	/** 
	 * sorts the funcs by their level (lowest level first)
	 * @param funcs
	 */
	private void sortByLevel(List<NameLink> funcs) {
		Collections.sort(funcs, new Comparator<NameLink>() {
			@Override
			public int compare(NameLink a, NameLink b) {
				return a.getLevel() - b.getLevel();
			}
		});
	}


	private void checkForDuplicateNames(WScope scope) {
		Multimap<String, NameLink> links = scope.attrNameLinks();
		for (String name : links.keySet()) {
			Collection<NameLink> nameLinks = links.get(name);
			if (nameLinks.size() <= 1) {
				continue;
			}
			List<NameLink> funcs = Lists.newArrayList();
			List<NameLink> other = Lists.newArrayList();
			for (NameLink nl : nameLinks) {
				if (nl.getDefinedIn() == scope) {
					if (nl.getType() == NameLinkType.FUNCTION) {
						funcs.add(nl);
					} else {
						other.add(nl);
					}
				}
			}
			if (other.size() > 1) {
				Collections.sort(other, new Comparator<NameLink>() {

					@Override
					public int compare(NameLink o1, NameLink o2) {
						return o1.getNameDef().attrSource().getLeftPos() 
								- o2.getNameDef().attrSource().getLeftPos() ;
					}
				});
				NameLink l1 = other.get(0);
				for (int j=1; j<other.size(); j++) {
					other.get(j).getNameDef().addError("An element with name " + name + " already exists: " +
							Utils.printElementWithSource(l1.getNameDef()));
				}
			}
			if (funcs.size() <= 1) {
				continue;
			}
			for (int i=0; i<funcs.size()-1; i++) {
				NameLink f1 = funcs.get(i);
				for (int j=i+1; j<funcs.size(); j++) {
					NameLink f2 = funcs.get(j);
					if (!distinctFunctions(f1, f2)) {
						f1.getNameDef().addError("Function already defined : " 
								+ Utils.printElementWithSource(f2.getNameDef()));
						f2.getNameDef().addError("Function already defined : " 
								+ Utils.printElementWithSource(f1.getNameDef()));
					}
				}
			}
		}
	}

	private boolean distinctFunctions(NameLink nl1, NameLink nl2) {
		if (nl1.getReceiverType() != null
				&& nl2.getReceiverType() != null	
				&& !nl1.getReceiverType().equalsType(nl2.getReceiverType(), nl1.getNameDef())) {
			return true;
		}
		FunctionDefinition f1 = (FunctionDefinition) nl1.getNameDef();
		FunctionDefinition f2 = (FunctionDefinition) nl2.getNameDef();
		WParameters ps1 = f1.getParameters();
		WParameters ps2 = f2.getParameters();
		if (ps1.size() != ps2.size()) {
			return true;
		}
		for (int i=0; i<ps1.size(); i++) {
			WurstType t1 = ps1.get(i).attrTyp();
			WurstType t2 = ps2.get(i).attrTyp();
			if (!t1.isSubtypeOf(t2, f1) && !t2.isSubtypeOf(t1, f1)) {
				return true;
			}
		}
		return false;
	}

	private void checkForDuplicateImports(WPackage p) {
		Set<String> imports = Sets.newLinkedHashSet();
		for (WImport imp : p.getImports()) {
			if (!imports.add(imp.getPackagename())) {
				imp.addError("The package " + imp.getPackagename() + " is already imported.");
			}
		}
	}

	private void checkVarDef(VarDef v) {
		v.attrTyp();

		if (v.attrTyp() instanceof WurstTypeCode && v.attrIsDynamicClassMember()) { 
			v.addError("Code members not allowed as dynamic class members (variable "+v.getName()+")\n" +
					"Try using a trigger or conditionfunc instead.");
		}
		
		if (v instanceof GlobalOrLocalVarDef) {
			GlobalOrLocalVarDef g = (GlobalOrLocalVarDef) v;
			if (g.attrIsConstant() && g.getInitialExpr() instanceof NoExpr) {
				g.addError("Constant variable " + g.getName() + " needs an initial value.");
			}
		}
		
		if (v.attrTyp() instanceof WurstTypeArray) {
			WurstTypeArray wta = (WurstTypeArray) v.attrTyp();
			if (wta.getDimensions() == 0) {
				v.addError("0-dimensionals arrays are not possible");
			} else if (wta.getDimensions() == 1) {
				if (!v.attrIsDynamicClassMember() && wta.getSize(0) != 0) {
					v.addError("Sized arrays are only supported as class members.");
				} else if (v.attrIsDynamicClassMember() && wta.getSize(0) == 0) {
					v.addError("Array members require a fixed size.");
				}
			} else {
				v.addError("Multidimensional Arrays are not yet supported.");
			}
		}
		
	}




	private void checkLocalShadowing(LocalVarDef v) {
		NameDef shadowed = v.getParent().getParent().lookupVar(v.getName(), false);
		if (shadowed instanceof LocalVarDef) {
			v.addError("Variable " + v.getName() + " hides an other local variable with the same name.");
		} else if (shadowed instanceof WParameter) {
			v.addError("Variable " + v.getName() + " hides a parameter with the same name.");
		}
	}

	private void checkConstructorSuperCall(ConstructorDef c) {
		if (c.getIsExplicit()) {
			if (c.attrNearestClassDef() instanceof ClassDef) {
				ClassDef classDef = (ClassDef) c.attrNearestClassDef();
				if (classDef.getExtendedClass() instanceof NoTypeExpr) {
					c.addError("Super call in a class which extends nothing.");
				}
			}
		}
	}

	private void checkParameter(WParameter param) {
		if (param.attrTyp() instanceof WurstTypeArray) {
			param.addError("Cannot use arrays as parameters.");
		}
	}
}
