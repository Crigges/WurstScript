//generated by parseq
package de.peeeq.wurstscript.ast;

class CompilationUnitImpl extends CompilationUnit implements SortPosIntern {
 	private SortPos parent;
	public SortPos getParent() { return parent; }
	public void setParent(SortPos parent) {
		if (parent != null && this.parent != null) { throw new Error("Parent already set."); }
		this.parent = parent;
	}

	protected void other_setParentToThis(TopLevelDeclaration t) {
		((SortPosIntern) t).setParent(this);
	}
	protected void other_clearParent(TopLevelDeclaration t) {
		((SortPosIntern) t).setParent(null);
	}
	@Override public <T> T match(WScope.Matcher<T> matcher) {
		return matcher.case_CompilationUnit(this);
	}
	@Override public void match(WScope.MatcherVoid matcher) {
		matcher.case_CompilationUnit(this);
	}

	@Override public <T> T match(PackageOrGlobal.Matcher<T> matcher) {
		return matcher.case_CompilationUnit(this);
	}
	@Override public void match(PackageOrGlobal.MatcherVoid matcher) {
		matcher.case_CompilationUnit(this);
	}

	@Override public void accept(WScope.Visitor v) {
		for (TopLevelDeclaration i : this ) {
			i.accept(v);
		}
		v.visit(this);
	}
	@Override public void accept(CompilationUnit.Visitor v) {
		for (TopLevelDeclaration i : this ) {
			i.accept(v);
		}
		v.visit(this);
	}
	@Override public void accept(PackageOrGlobal.Visitor v) {
		for (TopLevelDeclaration i : this ) {
			i.accept(v);
		}
		v.visit(this);
	}
}