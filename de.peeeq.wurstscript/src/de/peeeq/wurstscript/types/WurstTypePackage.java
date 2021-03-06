package de.peeeq.wurstscript.types;

import java.util.List;

import de.peeeq.wurstscript.ast.NamedScope;
import de.peeeq.wurstscript.ast.WPackage;
import de.peeeq.wurstscript.jassIm.ImExprOpt;
import de.peeeq.wurstscript.jassIm.ImType;


public class WurstTypePackage extends WurstTypeNamedScope {

	

	private WPackage pack;

	public WurstTypePackage(WPackage pack) {
		super(true);
		if (pack == null) throw new IllegalArgumentException();
		this.pack = pack;
	}

	@Override
	public NamedScope getDef() {
		return pack;
	}
	
	@Override
	public String getName() {
		return getDef().getName() + printTypeParams() + " (package)";
	}
	
	@Override
	public WurstType dynamic() {
		return this;
	}

	@Override
	public WurstType replaceTypeVars(List<WurstType> newTypes) {
		return this;
	}

	@Override
	public ImType imTranslateType() {
		throw new Error("not implemented");
	}

	@Override
	public ImExprOpt getDefaultValue() {
		throw new Error("not implemented");
	}

}
