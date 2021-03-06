package tests.wurstscript.tests;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class ModuleTests extends WurstScriptTest {
	
	private static final String TEST_DIR = "./testscripts/valid/modules/";

	
	@Test
	public void simple() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "simple.wurst"), true);
	}

	@Test
	public void multi1() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "multi.wurst"), true);
	}
	
	@Test
	public void multi2() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "multi2.wurst"), true);
	}
	
	@Test
	public void override() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "override.wurst"), true);
	}
	
	@Test
	public void override2() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "override2.wurst"), true);
	}
	
	@Test
	public void diamond1() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "diamond.wurst"), true);
	}
	
	@Test
	public void diamond2() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "diamond2.wurst"), true);
	}
	
	@Test
	public void initdestroy() throws IOException {
		testAssertOkFile(new File(TEST_DIR + "initdestroy.wurst"), true);
	}
	
	
	@Test
	public void modules_conflict() {
		testAssertErrorsLines(false, "ambiguous", 
				"package test",
				"	module A",
				"		function foo() returns int",
				"			return 3",
				"	module B",
				"		function foo() returns int",
				"			return 4",
				"	class C",
				"		use A",
				"		use B",
				"		function test()",
				"			foo()",
				"endpackage"
			);
	}
	
	
	@Test
	public void modules_thistype() {
		// each function in a module should be either private or public
		testAssertOkLines(true, 
				"package test",
				"	native testSuccess()",
				"	module A",
				"		function foo() returns thistype",
				"			return this",
				"	class C",
				"		use A",
				"	init",
				"		C c1 = new C()",
				"		C c2 = c1.foo()",
				"		if c1 == c2",
				"			testSuccess()",
				"endpackage"
			);
	}
	
	
	@Test
	public void modules_import() {
		// each function in a module should be either private or public
		testAssertOkLines(true,
				"package Blub",
				"	public module BlubModule",
				"		function foo() returns int",
				"			return 3",
				"endpackage",
				"package test",
				"	import Blub",
				"	native testSuccess()",
				"	class C",
				"		use BlubModule",
				"	init",
				"		C c = new C()",
				"		if c.foo() == 3",
				"			testSuccess()",
				"endpackage"
			);
	}
	
	@Test
	public void modules_call_global() {
		// each function in a module should be either private or public
		testAssertOkLines(true,
				"function random takes nothing returns int",
				"	return 3 // totally random, chosen by fair dice roll",
				"endfunction",
				"",
				"package test",
				"	native testSuccess()",
				"	module BlubModule",
				"		function foo() returns int",
				"			return random()",
				"	class C",
				"		use BlubModule",
				"	init",
				"		C c = new C()",
				"		if c.foo() == 3",
				"			testSuccess()",
				"endpackage"
			);
	}
	
	@Test
	public void modules_abstract() {
		testAssertOkLines(true, 
				"package test",
				"	native testSuccess()",
				"	module A",
				"		abstract function foo() returns int",
				"	class C",
				"		use A",
				"		override function foo() returns int",
				"			return 3",
				"",
				"	init",
				"		C c = new C()",
				"		if c.foo() == 3",
				"			testSuccess()",
				"endpackage"
			);
	}
	
	@Test
	public void modules_abstract_err() {
		testAssertErrorsLines(false, "must implement", 
				"package test",
				"	module A",
				"		abstract function foo() returns int",
				"	class C",
				"		use A",
				"endpackage"
			);
	}
	
	@Test
	public void modules_missing_override() {
		testAssertErrorsLines(false, "override", 
				"package test",
				"	module A",
				"		abstract function foo() returns int",
				"	class C",
				"		use A",
				"		function foo() returns int",
				"			return 3",
				"endpackage"
			);
	}
	
	@Test
	public void modules_wrong_param_count1() {
		testAssertErrorsLines(false, "parameter", 
				"package test",
				"	module A",
				"		function foo()",
				"			bar(3)",
				"		function bar()",
				"",
				"	class C",
				"		use A",
				"		function xyz()",
				"			foo()",
				"endpackage"
			);
	}
	
	@Test
	public void modules_wrong_param_count2() {
		testAssertErrorsLines(false, "not enough", 
				"package test",
				"	module A",
				"		function foo()",
				"			bar(3)",
				"		function bar(int x, int y)",
				"",
				"	class C",
				"		use A",
				"		function xyz()",
				"			foo()",
				"endpackage"
			);
	}
	
	@Test
	public void modules_call_indirect() {
		testAssertOkLines(false, 
				"package test",
				"	native testSuccess()",
				"	module A",
				"		function foo()",
				"			bar()",
				"		function bar()",
				"			testSuccess()",
				"	class C",
				"		use A",
				"		construct()",
				"			foo()",
				"	init",
				"		new C()",
				"endpackage"
			);
	}
	
	@Test
	public void static_external() {
		testAssertErrorsLines(false, "variable b",
				"package test",
				"	module A",
				"		static int b = 0",
				"	init",
				"		A.b = 0",
				"endpackage"
			);
	}
	
	@Test
	public void staticmeth_external() {
		testAssertErrorsLines(false, "method b is undefined",
				"package test",
				"	module A",
				"		static function b(int b)",
				"	init",
				"		A.b(0)",
				"endpackage"
			);
	}
	@Test
	public void moduleConstructor() { // see bug #150
		testAssertOkLines(false,
				"package Test",
				"module Test",
				"	construct()",
				"		skip",

				"class A",
				"	construct(int x)",
				"		skip",

				"class B extends A",
				"	use Test",
				"	construct()",
				"		super(3)"
				);
	}
	
	@Test
	public void overrideStatic() {
		testAssertErrorsLines(false, "override static function",
				"package Test",
				"module Test",
				"	abstract static function foo()",

				"class A",
				"	use Test",
				"	override function foo()",
				"		skip"
				);
	}
	
	@Test
	public void localInModuleConstructor() {
		testAssertOkLines(false, 
				"package Test",
				"module Test",
				"	construct()",
				"		int x = 5",
				"class A",
				"	use Test",
				"	construct()",
				"	construct(int i)"
				);
	}
	
	@Test
	public void localInModuleConstructor2() {
		testAssertOkLines(true, 
				"package Test",
				"native testSuccess()",
				"int res = 1", // 1) res == 1
				"module Test",
				"	construct()",
				"		int x = 2",
				"		res += x", // 2) res == 3 // 4) res == 6
				"	construct()",
				"		int y = 1",
				"		res -= y", // 3) res == 2  // 5) res == 5
				"class A",
				"	use Test",
				"	construct()",
				"		res *= 2", // 3) res == 4
				"	construct(int i)",
				"		res *= i", // 6) res == 15
				"init",
				"	new A()",
				"	new A(3)",
				"	if res == 15",
				"		testSuccess()"
				);
	}


	@Test
	public void modulesInSubclasses() { // bug #390
		testAssertOkLines(true,
				"package Test",
				"native testSuccess()",
				"native testFail(string message)",
				"module M",
				"	int i = 0",
				"class A",
				"	use M",
				"	function f()",
				"		i++",
				"		this.i++",
				"class B extends A",
				"	function g()",
				"		i++", // line 13
				"		this.i++",
				"		super.i++",
				"init",
				"	let b = new B()",
				"	A a = b",
				"	a.f()",
				"	b.g()",
				"	if a.i != 5",
				"		testFail(\"foo\")",
				"	testSuccess()");
	}
}
