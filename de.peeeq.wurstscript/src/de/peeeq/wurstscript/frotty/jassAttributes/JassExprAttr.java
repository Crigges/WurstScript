package de.peeeq.wurstscript.frotty.jassAttributes;

import de.peeeq.wurstscript.frotty.jassValidator.JassErrors;
import de.peeeq.wurstscript.jassAst.JassExpr;
import de.peeeq.wurstscript.jassAst.JassExprBinary;
import de.peeeq.wurstscript.jassAst.JassExprBoolVal;
import de.peeeq.wurstscript.jassAst.JassExprFuncRef;
import de.peeeq.wurstscript.jassAst.JassExprFunctionCall;
import de.peeeq.wurstscript.jassAst.JassExprIntVal;
import de.peeeq.wurstscript.jassAst.JassExprNull;
import de.peeeq.wurstscript.jassAst.JassExprRealVal;
import de.peeeq.wurstscript.jassAst.JassExprStringVal;
import de.peeeq.wurstscript.jassAst.JassExprUnary;
import de.peeeq.wurstscript.jassAst.JassExprVarAccess;
import de.peeeq.wurstscript.jassAst.JassExprVarArrayAccess;
import de.peeeq.wurstscript.jassAst.JassExprlist;
import de.peeeq.wurstscript.jassAst.JassSimpleVars;

public class JassExprAttr {

	public static String getType(JassExprBinary e) {
		if ( e.getLeftExpr().getType().equals(JassConstants.TYPE_INTEGER)) {
			return JassConstants.TYPE_INTEGER;
		}else if ( e.getLeftExpr().getType().equals(JassConstants.TYPE_REAL)) {
			return JassConstants.TYPE_REAL;
		}else if ( e.getLeftExpr().getType().equals(JassConstants.TYPE_STRING)) {
			return JassConstants.TYPE_STRING;
		}else 
		JassErrors.addError( "Binary Operator " + e.getOp() +" is not defined for " +
					"operands " + e.getLeftExpr() + " and " + e.getRight(), e.getLine());
		return "<unknown>";
	}
	
	public static String getType(JassExprUnary e) {
		if ( e.getRight().getType().equals(JassConstants.TYPE_INTEGER)) {
			return JassConstants.TYPE_INTEGER;
		}else if ( e.getRight().getType().equals(JassConstants.TYPE_REAL)) {
			return JassConstants.TYPE_REAL;
		}
		JassErrors.addError( "Unary Operator " + e.getOpU() +" is not defined for " +
							e.getRight(), e.getLine());
		return "<unknown>";
	}
	
	public static String getType(JassExprBoolVal e) {
		return JassConstants.TYPE_BOOLEAN;
	}
	
	public static String getType(JassExprFuncRef e) {
		return JassConstants.TYPE_CODE;
	}
	
	public static String getType(JassExprFunctionCall e) {
		JassSimpleVars params = e.attrFunctionCall().getParams();
		JassExprlist args = e.getArguments();
		int i = 0;
		for ( JassExpr je : args ) {
			if ( ! je.getType().equals(params.get(i).getType())) {
				JassErrors.addError( "Expected " + params.get(i).getType() + " as Paramater : " + i +
						", found " + je.getType(), e.getLine());
			}
			i++;
		}
		return e.attrFuncDef().getReturnType();
	}
	
	public static String getType(JassExprIntVal e) {
		return JassConstants.TYPE_INTEGER;
	}
	
	public static String getType(JassExprRealVal e) {
		return JassConstants.TYPE_REAL;
	}
	
	public static String getType(JassExprStringVal e) {
		return JassConstants.TYPE_STRING;
	}
	
	public static String getType(JassExprNull e) {
		return JassConstants.TYPE_NULL;
	}
	
	public static String getType(JassExprVarAccess e) {
		return e.attrVariableDefinition().getType();
	}
	
	public static String getType(JassExprVarArrayAccess e) {
		if ( ! e.getIndex().getType().equals(JassConstants.TYPE_INTEGER)) {
			JassErrors.addError( "Expected 'integer' as Array Index, found '" + e.getIndex().getType() + "'.", e.getLine());
		}
		return e.attrVariableDefinition().getType();
	}

}
