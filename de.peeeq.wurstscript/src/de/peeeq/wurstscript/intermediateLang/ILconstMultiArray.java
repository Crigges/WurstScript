package de.peeeq.wurstscript.intermediateLang;

import java.util.Map;

import com.google.common.collect.Maps;

import de.peeeq.datastructures.IntTuple;


public class ILconstMultiArray extends ILconstAbstract {
	
	private final Map<IntTuple, ILconst> contents = Maps.newHashMap();
	
	
	@Override
	public boolean isEqualTo(ILconst other) {
		throw new Error("not implemented");
	}

	@Override
	public String print() {
		return contents.toString();
	}
	
	public ILconst get(IntTuple key) {
		return contents.get(key);
	}
	
	public void set(IntTuple key, ILconst val) {
		contents.put(key, val);
	}

}
