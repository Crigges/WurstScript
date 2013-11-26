package de.peeeq.parseq.grammars.ast;

import org.antlr.v4.runtime.Token;

import de.peeeq.parseq.grammars.GrammarTranslation;



public class ProdRepeat extends Production {

	public final Production prod;
	public final RepeatType repType;

	public ProdRepeat(Production prod, RepeatType repType) {
		this.prod = prod;
		this.repType = repType;
		prod.setParent(this);
	}

	public static Production create(Production p, Token mod) {
		if (mod == null) {
			return p;
		}
		RepeatType repType;
		switch (mod.getText()) {
		case "+":
			repType = RepeatType.AT_LEAST_ONCE;
			break;
		case "*":
			repType = RepeatType.ARBITRARY;
			break;
		case "?":
			repType = RepeatType.ZERO_OR_ONCE;
			break;
		default:
			throw new Error(mod.getText());
		}
		return new ProdRepeat(p, repType);
	}

	@Override
	public void print(GrammarTranslation tr) {
		tr.print("(");
		prod.print(tr);
		tr.print(")");
		switch (repType) {
		case ARBITRARY:
			tr.print("*");
			break;
		case AT_LEAST_ONCE:
			tr.print("+");
			break;
		case ZERO_OR_ONCE:
			tr.print("+");
			break;
		}
	}
	
	
	
}
