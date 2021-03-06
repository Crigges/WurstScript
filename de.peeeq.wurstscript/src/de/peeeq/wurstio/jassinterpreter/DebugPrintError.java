package de.peeeq.wurstio.jassinterpreter;

import org.eclipse.jdt.annotation.Nullable;

import de.peeeq.wurstscript.intermediateLang.interpreter.ILStackFrame;
import de.peeeq.wurstscript.jassIm.ImStmt;
import de.peeeq.wurstscript.parser.WPos;

public class DebugPrintError extends Error {
	private @Nullable ILStackFrame stackFrame;
	private @Nullable ImStmt stmt;

	public DebugPrintError(String val) {
		super(val);
	}

	

	private static final long serialVersionUID = 629417346498474872L;
	
	@Override
	public String toString() {
		final ILStackFrame sf = stackFrame;
		ImStmt s = stmt;
		String err = "Wurst Error: " + getMessage();
		if (s != null) {
			WPos src = s.attrTrace().attrSource();
			err += " at line " + src.getLine();
		}
		if (sf != null) {
			err += sf.getMessage();
		}
		return err;
	}


}
