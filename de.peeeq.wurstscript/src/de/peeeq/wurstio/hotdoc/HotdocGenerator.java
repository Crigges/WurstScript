package de.peeeq.wurstio.hotdoc;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.eclipse.jdt.annotation.Nullable;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

import de.peeeq.wurstio.WurstCompilerJassImpl;
import de.peeeq.wurstscript.RunArgs;
import de.peeeq.wurstscript.WLogger;
import de.peeeq.wurstscript.ast.ExtensionFuncDef;
import de.peeeq.wurstscript.ast.FunctionDefinition;
import de.peeeq.wurstscript.ast.StructureDef;
import de.peeeq.wurstscript.ast.VarDef;
import de.peeeq.wurstscript.ast.WEntity;
import de.peeeq.wurstscript.ast.WPackage;
import de.peeeq.wurstscript.ast.WParameter;
import de.peeeq.wurstscript.ast.WurstModel;
import de.peeeq.wurstscript.attributes.CompileError;
import de.peeeq.wurstscript.gui.WurstGui;
import de.peeeq.wurstscript.gui.WurstGuiCliImpl;
import de.peeeq.wurstscript.utils.Utils;

public class HotdocGenerator {

	private List<String> files;
	private File outputfolder;
//	private WurstModel model;
//	private ArrayList<WPackage> packages;
	private VelocityEngine ve;
	private Template variableTemplate;
	private Template navbarTemplate;
	private Template structureTemplate;

	public HotdocGenerator(List<String> files) {
		this.files = Lists.newArrayList(files);
		this.outputfolder = new File(this.files.remove(files.size()-1));
		ve = new VelocityEngine();
		Properties p = new Properties();
		p.setProperty("eventhandler.include.class", "org.apache.velocity.app.event.implement.IncludeRelativePath");
		p.setProperty("runtime.references.strict", "true");
		ve.init(p);
		variableTemplate = ve.getTemplate("resources/hotdoc/var.html");
		navbarTemplate = ve.getTemplate("resources/hotdoc/navbar.html");
		structureTemplate = ve.getTemplate("resources/hotdoc/structure.html");
	}

	public void generateDoc() {
		try {
			WLogger.info("Generating hotdoc into " + outputfolder.getAbsolutePath());
			for (String f : files) {
				WLogger.info("	input: " + f);
			}
			if (outputfolder.exists()) {
				// clean folder
				for (File f : outputfolder.listFiles()) {
					if (f.getName().endsWith(".html")) {
						f.delete();
					}
				}
			} else {
				if (!outputfolder.mkdirs()) {
					throw new Error("could not create output directory");
				}
			}
			
			RunArgs runArgs = new RunArgs(new String[] {});
			WurstGui gui = new WurstGuiCliImpl();
			WurstCompilerJassImpl compiler = new WurstCompilerJassImpl(gui, null, runArgs);
			compiler.loadFiles("resources/common.j");
			compiler.loadFiles("resources/blizzard.j");
			for (String file: files) {
				File f = new File(file);
				if (!f.exists()) {
					WLogger.info("Folder " + f + " does not exist");
					continue;
				}
				if (f.isDirectory()) {
					compiler.loadWurstFilesInDir(f);
				} else {
					compiler.loadFiles(f);
				}
			}
			WurstModel model = compiler.parseFiles();
			if (model == null) {
				System.out.println("Hotdoc model is null.");
				for (CompileError e : gui.getErrorList()) {
					System.out.println(e);
				}
				throw new RuntimeException("Could not analyze program correctly.");
			}
			
			ArrayList<WPackage> packages = Lists.newArrayList(model.attrPackages().values());
			Collections.sort(packages, (o1, o2) -> o1.getSource().shortFile().compareTo(o2.getSource().shortFile()));
			
			createIndex(packages);
			for (WPackage p : packages) {
				createPackageDoc(p, packages);
			}
			gui.clearErrors();
		} catch (Throwable t) {
			System.err.println("Error in creating documentation: ");
			t.printStackTrace();
			throw new RuntimeException(t);
		}
	}

	private void createIndex(List<WPackage> packages) {
		Template t = ve.getTemplate("resources/hotdoc/document.html");
		
		VelocityContext context = new VelocityContext();
		context.put("title", "HotDoc Wurst Documentation");
		context.put("navbar", getNavbarWithHighlight(null, packages));
		context.put("content", "");
		String s = render(t, context);
		WLogger.info( s );     
		// TODO
		try {
			Files.write(render(t, context), new File(outputfolder + "/index.html"), Charsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void createPackageDoc(WPackage pack, List<WPackage> packages) {
		
        Template t = ve.getTemplate("resources/hotdoc/document.html");
	
		VelocityContext context = new VelocityContext();
		context.put("title", pack.getName() + " HotDoc Wurst Documentation");
		context.put("navbar", getNavbarWithHighlight(pack, packages));
		context.put("content", getPackageContent(pack));
		String s = render(t, context);
		WLogger.info( s );     
		// TODO
		try {
			Files.write(render(t, context), new File(outputfolder + "/" + pack.getName() + ".html"), Charsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String getPackageContent(WPackage pack) {
		Template t = ve.getTemplate("resources/hotdoc/package.html");
		VelocityContext context = new VelocityContext();
		context.put("currentPackage", pack);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		
		documentVars(getElements(pack, VarDef.class), writer, false);
		documentFuncs(getElements(pack, FunctionDefinition.class), writer, false);
		documentStructures(pack,writer);
		
		return writer.toString();
	}

	private void documentStructures(WPackage pack, StringWriter writer) {
		List<StructureDef> sorted = Utils.sortByName(getElements(pack, StructureDef.class));
		for (StructureDef v : sorted) {
			if (!v.attrIsPublic()) {
				continue;
			}
			
			VelocityContext context = new VelocityContext();
			context.put("name", Utils.printElement(v));
			context.put("type", "");
			context.put("comment", v.attrComment());
			context.put("source", v.getSource());
			
			structureTemplate.merge(context, writer);
			
			documentVars(v.getVars(), writer, true);
			documentFuncs(v.getMethods(), writer, true);
		}
		
	}

	private <T extends FunctionDefinition> void documentFuncs(List<T> funcs, StringWriter writer, boolean includeNonPublic) {
		funcs = Utils.sortByName(funcs);
		for (FunctionDefinition f : funcs) {
			if (!f.attrIsPublic()) {
				if (!includeNonPublic || f.attrIsPrivate() ) {
					continue;
				}
			}
			
			VelocityContext context = new VelocityContext();
			
			StringBuilder descr = new StringBuilder();
			descr.append("function ");
			if (f instanceof ExtensionFuncDef) {
				ExtensionFuncDef ex = (ExtensionFuncDef) f;
				descr.append(ex.getExtendedType().attrTyp());
				descr.append(".");
			}
			descr.append(f.getName());
			descr.append("(");
			boolean first = true;
			for (WParameter p : f.getParameters()) {
				if (!first) {
					descr.append(", ");
				}
				descr.append(p.attrTyp() + " " + p.getName());
				first = false;
			}
			descr.append(")");
			if (f.getReturnTyp().attrTyp().isVoid()) {
				
			} else {
				descr.append(" returns ");
				descr.append(f.getReturnTyp().attrTyp());
			}
			
			context.put("name", descr);
			context.put("type", "");
			context.put("comment", f.attrComment());
			context.put("source", f.getSource());
			
			variableTemplate.merge(context, writer);
		}
	}

	private <T extends VarDef> void documentVars(List<T> vardefs, StringWriter writer, boolean includeNonPublic) {
		List<T> sorted = Utils.sortByName(vardefs);
		for (VarDef v : sorted) {
			if (!v.attrIsPublic()) {
				if (!includeNonPublic || v.attrIsPrivate() ) {
					continue;
				}
			}
			
			VelocityContext context = new VelocityContext();
			context.put("name", v.getName());
			context.put("type", v.attrTyp());
			context.put("comment", v.attrComment());
			context.put("source", v.getSource());
			
			variableTemplate.merge(context, writer);
		}
	}

	private <T> List<T> getElements(WPackage pack, Class<T> clazz) {
		List<T> result = Lists.newArrayList();
		for (WEntity e : pack.getElements()) {
			WLogger.info(Utils.printElement(e));
			if (clazz.isAssignableFrom(e.getClass())) {
				@SuppressWarnings("unchecked")
				T t = (T) e;
				result.add(t);
			}
		}
		return result;
	}

	private String render(Template t, VelocityContext context) {
		StringWriter writer = new StringWriter();
        t.merge( context, writer );
        String s = writer.toString();
		return s;
	}

	private String getNavbarWithHighlight(@Nullable WPackage pack, List<WPackage> packages) {
		VelocityContext context = new VelocityContext();
		context.put("packages", packages);
		context.put("currentPackage", pack);
		return render(navbarTemplate, context);
	}


}
