package de.peeeq.wurstscript.tests;


import static org.testng.AssertJUnit.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import de.peeeq.wurstscript.WurstCompiler;
import de.peeeq.wurstscript.WurstCompilerImpl;
import de.peeeq.wurstscript.gui.WurstGui;
import de.peeeq.wurstscript.gui.WurstGuiCliImpl;
import de.peeeq.wurstscript.gui.WurstGuiLogger;
import de.peeeq.wurstscript.intermediateLang.ILprog;
import de.peeeq.wurstscript.intermediateLang.interpreter.ILInterpreter;
import de.peeeq.wurstscript.intermediateLang.interpreter.ILInterpreterImpl;
import de.peeeq.wurstscript.intermediateLang.interpreter.TestFailException;
import de.peeeq.wurstscript.intermediateLang.interpreter.TestSuccessException;
import de.peeeq.wurstscript.utils.NotNullList;

public class TestScriptsTestNG {

	private final static String PSCRIPT_ENDING = ".pscript";
	
	@DataProvider
	public Object[][] getTestfiles() {
		File dir = new File("./testscripts/valid");

		boolean exists = dir.exists();
		if (exists) {
			System.out.println("Directory " + dir + " exists!");
		} else {
			System.out.println("Directory " + dir + " could not be found!");
		}

		File[] fileList = dir.listFiles();
		List<File> pscriptFiles = new NotNullList<File>();

		if (fileList != null) {
			for (File f : fileList) {
				String name = f.getName().toLowerCase();
				if (name.endsWith(PSCRIPT_ENDING)) {
					pscriptFiles.add(f);
				}

			}
		}
		Object[][] result = new Object[pscriptFiles.size()][];
		int i = 0;
		for (File f : pscriptFiles) {
			Object[] fa = {f};
			result[i] = fa;
			i++;
		}
		return result;
	}

	@Test(dataProvider = "getTestfiles")
	public void testScript(File file) {
		try {
			System.out.println("file b = " + file);
			String filename = file.getAbsolutePath();
			System.out.println("parsing script ...");
			WurstGuiLogger gui = new WurstGuiLogger();
			WurstCompiler compiler = new WurstCompilerImpl(gui);
			compiler.loadFiles(file);
			compiler.parseFiles();

			ILprog prog = compiler.getILprog();

			if (prog == null) {
				throw new TestFailException("Compiler errors:\n" + gui.getErrors());
			}
			
			if (gui.getErrorCount() > 0) {
				throw new TestFailException("Compiler Errors:\n" + gui.getErrors());
			}

			File outputFile = new File(filename.replaceAll("\\"+PSCRIPT_ENDING, ".j"));
			StringBuilder sb = new StringBuilder();
			prog.printJass(sb, 0);
			try {
				FileWriter writer = new FileWriter(outputFile, false);
				writer.append(sb.toString());
				writer.close();
			} catch (IOException e) {
				throw new Error(e);
			}

			ILInterpreter interpreter = new ILInterpreterImpl();
			interpreter.LoadProgram(prog);
			interpreter.executeFunction("test_runTest");
		} catch (TestFailException e) {
			assertTrue("Failed: " + e.getVal(), false);
		} catch (TestSuccessException e)  {
			
		}
	}

}