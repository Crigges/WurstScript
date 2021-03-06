package de.peeeq.wurstscript.translation.imtojass;

import static de.peeeq.wurstscript.jassAst.JassAst.JassStatements;
import static de.peeeq.wurstscript.jassAst.JassAst.JassStmtExitwhen;
import static de.peeeq.wurstscript.jassAst.JassAst.JassStmtIf;
import static de.peeeq.wurstscript.jassAst.JassAst.JassStmtLoop;
import static de.peeeq.wurstscript.jassAst.JassAst.JassStmtReturn;
import static de.peeeq.wurstscript.jassAst.JassAst.JassStmtReturnVoid;
import static de.peeeq.wurstscript.jassAst.JassAst.JassStmtSet;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import de.peeeq.wurstscript.jassAst.JassAst;
import de.peeeq.wurstscript.jassAst.JassAstElement;
import de.peeeq.wurstscript.jassAst.JassExpr;
import de.peeeq.wurstscript.jassAst.JassExprFunctionCall;
import de.peeeq.wurstscript.jassAst.JassFunction;
import de.peeeq.wurstscript.jassAst.JassStatement;
import de.peeeq.wurstscript.jassAst.JassStatements;
import de.peeeq.wurstscript.jassAst.JassVar;
import de.peeeq.wurstscript.jassIm.ImExitwhen;
import de.peeeq.wurstscript.jassIm.ImExpr;
import de.peeeq.wurstscript.jassIm.ImIf;
import de.peeeq.wurstscript.jassIm.ImLoop;
import de.peeeq.wurstscript.jassIm.ImNoExpr;
import de.peeeq.wurstscript.jassIm.ImReturn;
import de.peeeq.wurstscript.jassIm.ImSet;
import de.peeeq.wurstscript.jassIm.ImSetArray;
import de.peeeq.wurstscript.jassIm.ImSetArrayMulti;
import de.peeeq.wurstscript.jassIm.ImSetArrayTuple;
import de.peeeq.wurstscript.jassIm.ImSetTuple;
import de.peeeq.wurstscript.jassIm.ImStmt;
import de.peeeq.wurstscript.jassIm.ImStmts;
import de.peeeq.wurstscript.jassIm.JassImElement;

public class StatementTranslation {


	public static void translate(ImExitwhen imExitwhen, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		stmts.add(JassStmtExitwhen(imExitwhen.getCondition().translate(translator)));
	}

	public static void translate(ImIf imIf, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		JassExpr cond = imIf.getCondition().translate(translator);
		JassStatements thenBlock = JassStatements(); 
		imIf.getThenBlock().translate(thenBlock, f, translator);
		JassStatements elseBlock = JassStatements();
		imIf.getElseBlock().translate(elseBlock, f, translator);
		stmts.add(JassStmtIf(cond, thenBlock, elseBlock));
	}


	public static void translate(ImLoop imLoop, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		JassStatements body = JassStatements();
		imLoop.getBody().translate(body, f, translator);
		stmts.add(JassStmtLoop(body));
	}

	public static void translate(ImReturn imReturn, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		if (imReturn.getReturnValue() instanceof ImNoExpr) {
			stmts.add(JassStmtReturnVoid());
		} else {
			ImExpr e = (ImExpr) imReturn.getReturnValue();
			JassExpr returnValue = e.translate(translator);
			stmts.add(JassStmtReturn(returnValue));
		}
	}

	public static void translate(ImSet imSet, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		JassVar vars = translator.getJassVarFor(imSet.getLeft());
		JassExpr exprs = imSet.getRight().translate(translator);
		stmts.add(JassStmtSet(vars.getName(), exprs));
	}

	public static void translate(ImExpr imExpr, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		JassExpr expr = imExpr.translate(translator);
		// only add the function calls from this expression, the rest can not have any side effects
		addAllCalls(stmts, expr);
	}

	

	private static void addAllCalls(List<JassStatement> stmts, JassAstElement expr) {
		if (expr instanceof JassExprFunctionCall) {
			JassExprFunctionCall fc = (JassExprFunctionCall) expr;
			stmts.add(JassAst.JassStmtCall(fc.getFuncName(), fc.getArguments().copy()));
		} else {
			// visit children
			for (int i=0; i<expr.size(); i++) {
				addAllCalls(stmts, expr.get(i));
			}
		}
	}

	public static void translate(ImSetArray imSet, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		JassVar leftVar = translator.getJassVarFor(imSet.getLeft());
		JassExpr right = imSet.getRight().translate(translator);
		stmts.add(JassAst.JassStmtSetArray(leftVar.getName(), imSet.getIndex().translate(translator), right));			
	}
	
	public static void translate(ImSetArrayTuple imSet, List<JassStatement> stmts, JassFunction f,
			ImToJassTranslator translator) {
		throw new Error("tuples should be eliminated in earlier phase");
	}

	public static void translate(ImSetTuple imSet, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		throw new Error("tuples should be eliminated in earlier phase");
	}

	public static void translate(ImStmts imStmts, List<JassStatement> stmts, JassFunction f, ImToJassTranslator translator) {
		for (ImStmt s : imStmts) {
			s.translate(stmts, f, translator);
		}
	}

	public static void translate(ImSetArrayMulti imSetArrayMulti,
			List<JassStatement> stmts, JassFunction f,
			ImToJassTranslator translator) {
		throw new Error("not implemented");
		
	}


}
