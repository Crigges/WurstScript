
/*
 * generated by Xtext
 */
package de.peeeq.pscript.generator;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Main {
	
	public static void main(String[] args) {
//		if (args.length==0) {
//			System.err.println("Aborting: no path to EMF resource provided!");
//			return;
//		}
		Injector injector = new de.peeeq.pscript.PscriptStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		Main main = injector.getInstance(Main.class);
//		main.runGenerator(args[0]);
//		main.runGenerator("file://C:/pscript/de.peeeq.Pscript2/src/de/peeeq/pscript/intermediateLang/interpreter/test.pscript");
		main.runGenerator("platform:/resource/de.peeeq.Pscript2/src/de/peeeq/pscript/generator/test.pscript");
	}
	
	@Inject 
	private Provider<ResourceSet> resourceSetProvider;
	
	@Inject
	private IResourceValidator validator;
	
	@Inject
	private IGenerator generator;
	
	@Inject 
	private JavaIoFileSystemAccess fileAccess;

	protected void runGenerator(String string) {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(string), true);
		
		// validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return;
		}
		
		// configure and start the generator
		fileAccess.setOutputPath("src-gen/");
		generator.doGenerate(resource, fileAccess);
		
		System.out.println("Code generation finished.");
	}
}