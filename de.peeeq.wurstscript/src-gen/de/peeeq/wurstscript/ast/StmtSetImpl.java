//generated by parseq
package de.peeeq.wurstscript.ast;

class StmtSetImpl implements StmtSet, SortPosIntern {
	StmtSetImpl(WPos source, ExprAssignable left, OpAssignment op, Expr right) {
		if (source == null) throw new IllegalArgumentException();
		((SortPosIntern)source).setParent(this);
		this.source = source;
		if (left == null) throw new IllegalArgumentException();
		((SortPosIntern)left).setParent(this);
		this.left = left;
		if (op == null) throw new IllegalArgumentException();
		((SortPosIntern)op).setParent(this);
		this.op = op;
		if (right == null) throw new IllegalArgumentException();
		((SortPosIntern)right).setParent(this);
		this.right = right;
	}

	private SortPos parent;
	public SortPos getParent() { return parent; }
	public void setParent(SortPos parent) {
		if (parent != null && this.parent != null) { throw new Error("Parent already set."); }
		this.parent = parent;
	}

	private WPos source;
	public void setSource(WPos source) {
		if (source == null) throw new IllegalArgumentException();
		((SortPosIntern)this.source).setParent(null);
		((SortPosIntern)source).setParent(this);
		this.source = source;
	} 
	public WPos getSource() { return source; }

	private ExprAssignable left;
	public void setLeft(ExprAssignable left) {
		if (left == null) throw new IllegalArgumentException();
		((SortPosIntern)this.left).setParent(null);
		((SortPosIntern)left).setParent(this);
		this.left = left;
	} 
	public ExprAssignable getLeft() { return left; }

	private OpAssignment op;
	public void setOp(OpAssignment op) {
		if (op == null) throw new IllegalArgumentException();
		((SortPosIntern)this.op).setParent(null);
		((SortPosIntern)op).setParent(this);
		this.op = op;
	} 
	public OpAssignment getOp() { return op; }

	private Expr right;
	public void setRight(Expr right) {
		if (right == null) throw new IllegalArgumentException();
		((SortPosIntern)this.right).setParent(null);
		((SortPosIntern)right).setParent(this);
		this.right = right;
	} 
	public Expr getRight() { return right; }

	@Override public void accept(JassToplevelDeclaration.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(StmtWhile.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(WStatement.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(WStatements.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(StmtLoop.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(ClassMember.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(FunctionDefinition.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(ClassSlot.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(TypeDef.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(OnDestroyDef.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(StmtIf.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(WEntity.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(ConstructorDef.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(FuncDef.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(ClassSlots.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(WPackage.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(ClassDef.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(WEntities.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(WScope.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(StmtSet.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(InitBlock.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(TopLevelDeclaration.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(CompilationUnit.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public void accept(PackageOrGlobal.Visitor v) {
		source.accept(v);
		left.accept(v);
		op.accept(v);
		right.accept(v);
		v.visit(this);
	}
	@Override public <T> T match(WStatement.Matcher<T> matcher) {
		return matcher.case_StmtSet(this);
	}
	@Override public void match(WStatement.MatcherVoid matcher) {
		matcher.case_StmtSet(this);
	}

}