package de.peeeq.wurstscript.types;

import de.peeeq.wurstscript.ast.ClassDef;
import de.peeeq.wurstscript.ast.ClassOrModule;
import de.peeeq.wurstscript.ast.ModuleDef;
import de.peeeq.wurstscript.jassIm.ImSimpleType;
import de.peeeq.wurstscript.jassIm.ImType;

public class TypesHelper {

	private static final ImSimpleType intType = WurstTypeInt.instance().imTranslateType();

	


	public static ImSimpleType imInt() {
		return intType;
	}
	
	public static ImSimpleType imString() {
		return WurstTypeString.instance().imTranslateType();
	}

	public static ImType imVoid() {
		return WurstTypeVoid.instance().imTranslateType();
	}


	public static ImType imBool() {
		return WurstTypeBool.instance().imTranslateType();
	}

//	public static boolean checkTypeArgs(InstanceDef iDef, List<PscriptType> classParams, List<PscriptType> interfaceParams) {
//		if (classParams.size() == 0 && interfaceParams.size() == 0) {
//			return true;
//		}
//		
//		Map<TypeParamDef, PscriptType> typeParamBinding = Maps.newLinkedHashMap(); 
//		
//		PscriptTypeClass classType = (PscriptTypeClass) iDef.getClassTyp().attrTyp();
//		int i = 0;
//		for (PscriptType classTp : classType.getTypeParameters()) {
//			PscriptTypeTypeParam classTp2 = (PscriptTypeTypeParam) classTp;
//			TypeParamDef tpDef = classTp2.getDef();
//			typeParamBinding.put(tpDef, classParams.get(i));
//			i++;
//		}
//		
//		ArrayList<PscriptType> actualInterfaceTypes = Lists.newArrayList();
//		
//		PscriptTypeInterface interfaceType = (PscriptTypeInterface) iDef.getImplementedTyp().attrTyp();
//		for (PscriptType intTp : interfaceType.getTypeParameters()) {
//			if (intTp instanceof PscriptTypeTypeParam) {
//				PscriptTypeTypeParam intTp2 = (PscriptTypeTypeParam) intTp;
//				actualInterfaceTypes.add(typeParamBinding.get(intTp2.getDef()));
//			} else {
//				actualInterfaceTypes.add(intTp);
//			}
//		}
//		
//		if (actualInterfaceTypes.size() != interfaceParams.size()) {
//			throw new CompileError(iDef.getSource(), "sizes do not match: " + actualInterfaceTypes.size()+ " != " + interfaceParams.size());
//		}
//		
//		i = 0;
//		for (PscriptType iTp : interfaceParams) {
//			if (!iTp.equalsType(actualInterfaceTypes.get(i), iDef)) {
//				return false;
//			}
//			i++;
//		}
//		
//		
//		return true;
//	}


}
