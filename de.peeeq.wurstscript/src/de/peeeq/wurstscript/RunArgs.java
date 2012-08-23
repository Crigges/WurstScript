package de.peeeq.wurstscript;

import java.util.List;

import com.google.common.collect.Lists;

public class RunArgs {

	private List<String> files  = Lists.newArrayList();
	private boolean optimize = false;
	private boolean gui = false;
	private String mapFile = null;
	private String outFile = null;
	private boolean showAbout = false;
	private boolean showLastErrors = false;
	private boolean inline;
	private boolean runCompiletimeFunctions;
	private boolean runtests;
	
	public static RunArgs defaults() {
		return new RunArgs(new String[] {});
	}
	
	public RunArgs(String[] args) {
		for (int i=0; i<args.length; i++) {
			String a = args[i];
			if (a.startsWith("-")) {
				if (a.equals("-opt")) {
					this.optimize = true;
				} else if (a.equals("-inline")) {
					inline = true;
				} else if (a.equals("-runtests")) {
					runtests = true;
				} else if (a.equals("-gui")) {
					this.gui = true;
				} else if (a.equals("-out")) {
					i++;
					this.outFile = args[i];
				} else if (a.equals("--about")) {
					this.showAbout = true;			
				} else if (a.equals("--showerrors")) {
					this.showLastErrors = true;
				} else if (a.equals("-runcompiletimefunctions")) {
					runCompiletimeFunctions  = true;
				} else {
					throw new Error("Unknown option: " + a);
				}
			} else {
				files.add(a);
				if (a.endsWith(".w3x") || a.endsWith(".w3g")) {
					mapFile = a;
				}
			}
		}
	}

	public List<String> getFiles() {
		return files;
	}

	public boolean isOptimize() {
		return optimize;
	}

	public boolean isGui() {
		return gui;
	}

	public String getMapFile() {
		return mapFile;
	}

	public String getOutFile() {
		return outFile;
	}

	public boolean showAbout() {
		return showAbout;
	}

	public boolean showLastErrors() {
		return showLastErrors;
	}

	public boolean isInline() {
		return inline;
	}

	public boolean runCompiletimeFunctions() {
		return runCompiletimeFunctions;
	}

	public boolean runtests() {
		return runtests;
	}



}
