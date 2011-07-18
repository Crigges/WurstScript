/**
 * <copyright>
 * </copyright>
 *

 */
package de.peeeq.pscript.pscript;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.peeeq.pscript.pscript.PscriptFactory
 * @model kind="package"
 * @generated
 */
public interface PscriptPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "pscript";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.peeeq.de/pscript/Pscript";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "pscript";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  PscriptPackage eINSTANCE = de.peeeq.pscript.pscript.impl.PscriptPackageImpl.init();

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ProgramImpl <em>Program</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ProgramImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getProgram()
   * @generated
   */
  int PROGRAM = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM__PACKAGES = 0;

  /**
   * The number of structural features of the '<em>Program</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROGRAM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.PackageDeclarationImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getPackageDeclaration()
   * @generated
   */
  int PACKAGE_DECLARATION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Imports</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__IMPORTS = 1;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION__ELEMENTS = 2;

  /**
   * The number of structural features of the '<em>Package Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ImportImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 2;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.EntityImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = 0;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.InitBlockImpl <em>Init Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.InitBlockImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getInitBlock()
   * @generated
   */
  int INIT_BLOCK = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_BLOCK__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_BLOCK__BODY = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Init Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INIT_BLOCK_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.TypeDefImpl <em>Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.TypeDefImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeDef()
   * @generated
   */
  int TYPE_DEF = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF__NAME = ENTITY__NAME;

  /**
   * The number of structural features of the '<em>Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.FuncDefImpl <em>Func Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.FuncDefImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getFuncDef()
   * @generated
   */
  int FUNC_DEF = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNC_DEF__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNC_DEF__PARAMETERS = ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNC_DEF__TYPE = ENTITY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNC_DEF__BODY = ENTITY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Func Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNC_DEF_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ClassMemberImpl <em>Class Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ClassMemberImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getClassMember()
   * @generated
   */
  int CLASS_MEMBER = 7;

  /**
   * The number of structural features of the '<em>Class Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_MEMBER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.VarDefImpl <em>Var Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.VarDefImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getVarDef()
   * @generated
   */
  int VAR_DEF = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DEF__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Constant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DEF__CONSTANT = ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DEF__TYPE = ENTITY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DEF__E = ENTITY_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Var Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DEF_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.TypeExprImpl <em>Type Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.TypeExprImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeExpr()
   * @generated
   */
  int TYPE_EXPR = 9;

  /**
   * The number of structural features of the '<em>Type Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StatementsImpl <em>Statements</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StatementsImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStatements()
   * @generated
   */
  int STATEMENTS = 10;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENTS__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Statements</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENTS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StatementImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 11;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtExitwhenImpl <em>Stmt Exitwhen</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtExitwhenImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtExitwhen()
   * @generated
   */
  int STMT_EXITWHEN = 12;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_EXITWHEN__E = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Stmt Exitwhen</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_EXITWHEN_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtLoopImpl <em>Stmt Loop</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtLoopImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtLoop()
   * @generated
   */
  int STMT_LOOP = 13;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_LOOP__BODY = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Stmt Loop</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_LOOP_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtReturnImpl <em>Stmt Return</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtReturnImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtReturn()
   * @generated
   */
  int STMT_RETURN = 14;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_RETURN__E = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Stmt Return</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_RETURN_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtIfImpl <em>Stmt If</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtIfImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtIf()
   * @generated
   */
  int STMT_IF = 15;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_IF__COND = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_IF__THEN_BLOCK = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else If Conds</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_IF__ELSE_IF_CONDS = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Else If Blocks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_IF__ELSE_IF_BLOCKS = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Else Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_IF__ELSE_BLOCK = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Stmt If</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_IF_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtWhileImpl <em>Stmt While</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtWhileImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtWhile()
   * @generated
   */
  int STMT_WHILE = 16;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_WHILE__COND = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_WHILE__BODY = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Stmt While</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_WHILE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtSetOrCallImpl <em>Stmt Set Or Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtSetOrCallImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtSetOrCall()
   * @generated
   */
  int STMT_SET_OR_CALL = 17;

  /**
   * The number of structural features of the '<em>Stmt Set Or Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_SET_OR_CALL_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpAssignmentImpl <em>Op Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpAssignmentImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpAssignment()
   * @generated
   */
  int OP_ASSIGNMENT = 18;

  /**
   * The number of structural features of the '<em>Op Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_ASSIGNMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExpr()
   * @generated
   */
  int EXPR = 19;

  /**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpEqualityImpl <em>Op Equality</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpEqualityImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpEquality()
   * @generated
   */
  int OP_EQUALITY = 20;

  /**
   * The number of structural features of the '<em>Op Equality</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_EQUALITY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpComparisonImpl <em>Op Comparison</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpComparisonImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpComparison()
   * @generated
   */
  int OP_COMPARISON = 21;

  /**
   * The number of structural features of the '<em>Op Comparison</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_COMPARISON_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpAdditiveImpl <em>Op Additive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpAdditiveImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpAdditive()
   * @generated
   */
  int OP_ADDITIVE = 22;

  /**
   * The number of structural features of the '<em>Op Additive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_ADDITIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpMultiplicativeImpl <em>Op Multiplicative</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpMultiplicativeImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMultiplicative()
   * @generated
   */
  int OP_MULTIPLICATIVE = 23;

  /**
   * The number of structural features of the '<em>Op Multiplicative</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_MULTIPLICATIVE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprListImpl <em>Expr List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprListImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprList()
   * @generated
   */
  int EXPR_LIST = 24;

  /**
   * The feature id for the '<em><b>Params</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIST__PARAMS = 0;

  /**
   * The number of structural features of the '<em>Expr List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.NativeFuncImpl <em>Native Func</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.NativeFuncImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getNativeFunc()
   * @generated
   */
  int NATIVE_FUNC = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_FUNC__NAME = FUNC_DEF__NAME;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_FUNC__PARAMETERS = FUNC_DEF__PARAMETERS;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_FUNC__TYPE = FUNC_DEF__TYPE;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_FUNC__BODY = FUNC_DEF__BODY;

  /**
   * The number of structural features of the '<em>Native Func</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_FUNC_FEATURE_COUNT = FUNC_DEF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.NativeTypeImpl <em>Native Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.NativeTypeImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getNativeType()
   * @generated
   */
  int NATIVE_TYPE = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_TYPE__NAME = TYPE_DEF__NAME;

  /**
   * The feature id for the '<em><b>Super Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_TYPE__SUPER_NAME = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Native Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NATIVE_TYPE_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ClassDefImpl <em>Class Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ClassDefImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getClassDef()
   * @generated
   */
  int CLASS_DEF = 27;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEF__NAME = TYPE_DEF__NAME;

  /**
   * The feature id for the '<em><b>Members</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEF__MEMBERS = TYPE_DEF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Class Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASS_DEF_FEATURE_COUNT = TYPE_DEF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.TypeExprRefImpl <em>Type Expr Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.TypeExprRefImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeExprRef()
   * @generated
   */
  int TYPE_EXPR_REF = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_EXPR_REF__NAME = TYPE_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Expr Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_EXPR_REF_FEATURE_COUNT = TYPE_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.TypeExprBuildinImpl <em>Type Expr Buildin</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.TypeExprBuildinImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeExprBuildin()
   * @generated
   */
  int TYPE_EXPR_BUILDIN = 29;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_EXPR_BUILDIN__NAME = TYPE_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Expr Buildin</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_EXPR_BUILDIN_FEATURE_COUNT = TYPE_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ParameterDefImpl <em>Parameter Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ParameterDefImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getParameterDef()
   * @generated
   */
  int PARAMETER_DEF = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DEF__NAME = VAR_DEF__NAME;

  /**
   * The feature id for the '<em><b>Constant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DEF__CONSTANT = VAR_DEF__CONSTANT;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DEF__TYPE = VAR_DEF__TYPE;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DEF__E = VAR_DEF__E;

  /**
   * The number of structural features of the '<em>Parameter Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DEF_FEATURE_COUNT = VAR_DEF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtCallImpl <em>Stmt Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtCallImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtCall()
   * @generated
   */
  int STMT_CALL = 31;

  /**
   * The feature id for the '<em><b>E</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_CALL__E = STMT_SET_OR_CALL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Stmt Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_CALL_FEATURE_COUNT = STMT_SET_OR_CALL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.StmtSetImpl <em>Stmt Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.StmtSetImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtSet()
   * @generated
   */
  int STMT_SET = 32;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_SET__LEFT = STMT_SET_OR_CALL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op Assignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_SET__OP_ASSIGNMENT = STMT_SET_OR_CALL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_SET__RIGHT = STMT_SET_OR_CALL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Stmt Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STMT_SET_FEATURE_COUNT = STMT_SET_OR_CALL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpAssignImpl <em>Op Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpAssignImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpAssign()
   * @generated
   */
  int OP_ASSIGN = 33;

  /**
   * The number of structural features of the '<em>Op Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_ASSIGN_FEATURE_COUNT = OP_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpPlusAssignImpl <em>Op Plus Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpPlusAssignImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpPlusAssign()
   * @generated
   */
  int OP_PLUS_ASSIGN = 34;

  /**
   * The number of structural features of the '<em>Op Plus Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_PLUS_ASSIGN_FEATURE_COUNT = OP_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpMinusAssignImpl <em>Op Minus Assign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpMinusAssignImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMinusAssign()
   * @generated
   */
  int OP_MINUS_ASSIGN = 35;

  /**
   * The number of structural features of the '<em>Op Minus Assign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_MINUS_ASSIGN_FEATURE_COUNT = OP_ASSIGNMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprOrImpl <em>Expr Or</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprOrImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprOr()
   * @generated
   */
  int EXPR_OR = 36;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_OR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_OR__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_OR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Expr Or</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_OR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprAndImpl <em>Expr And</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprAndImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprAnd()
   * @generated
   */
  int EXPR_AND = 37;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_AND__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_AND__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_AND__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Expr And</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_AND_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprEqualityImpl <em>Expr Equality</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprEqualityImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprEquality()
   * @generated
   */
  int EXPR_EQUALITY = 38;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_EQUALITY__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_EQUALITY__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_EQUALITY__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Expr Equality</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_EQUALITY_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpEqualsImpl <em>Op Equals</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpEqualsImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpEquals()
   * @generated
   */
  int OP_EQUALS = 39;

  /**
   * The number of structural features of the '<em>Op Equals</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_EQUALS_FEATURE_COUNT = OP_EQUALITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpUnequalsImpl <em>Op Unequals</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpUnequalsImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpUnequals()
   * @generated
   */
  int OP_UNEQUALS = 40;

  /**
   * The number of structural features of the '<em>Op Unequals</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_UNEQUALS_FEATURE_COUNT = OP_EQUALITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprComparisonImpl <em>Expr Comparison</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprComparisonImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprComparison()
   * @generated
   */
  int EXPR_COMPARISON = 41;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_COMPARISON__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_COMPARISON__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_COMPARISON__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Expr Comparison</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_COMPARISON_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpLessEqImpl <em>Op Less Eq</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpLessEqImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpLessEq()
   * @generated
   */
  int OP_LESS_EQ = 42;

  /**
   * The number of structural features of the '<em>Op Less Eq</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_LESS_EQ_FEATURE_COUNT = OP_COMPARISON_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpLessImpl <em>Op Less</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpLessImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpLess()
   * @generated
   */
  int OP_LESS = 43;

  /**
   * The number of structural features of the '<em>Op Less</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_LESS_FEATURE_COUNT = OP_COMPARISON_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpGreaterEqImpl <em>Op Greater Eq</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpGreaterEqImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpGreaterEq()
   * @generated
   */
  int OP_GREATER_EQ = 44;

  /**
   * The number of structural features of the '<em>Op Greater Eq</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_GREATER_EQ_FEATURE_COUNT = OP_COMPARISON_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpGreaterImpl <em>Op Greater</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpGreaterImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpGreater()
   * @generated
   */
  int OP_GREATER = 45;

  /**
   * The number of structural features of the '<em>Op Greater</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_GREATER_FEATURE_COUNT = OP_COMPARISON_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprAdditiveImpl <em>Expr Additive</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprAdditiveImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprAdditive()
   * @generated
   */
  int EXPR_ADDITIVE = 46;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_ADDITIVE__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_ADDITIVE__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_ADDITIVE__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Expr Additive</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_ADDITIVE_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpPlusImpl <em>Op Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpPlusImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpPlus()
   * @generated
   */
  int OP_PLUS = 47;

  /**
   * The number of structural features of the '<em>Op Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_PLUS_FEATURE_COUNT = OP_ADDITIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpMinusImpl <em>Op Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpMinusImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMinus()
   * @generated
   */
  int OP_MINUS = 48;

  /**
   * The number of structural features of the '<em>Op Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_MINUS_FEATURE_COUNT = OP_ADDITIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprMultImpl <em>Expr Mult</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprMultImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprMult()
   * @generated
   */
  int EXPR_MULT = 49;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MULT__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MULT__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MULT__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Expr Mult</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MULT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpMultImpl <em>Op Mult</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpMultImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMult()
   * @generated
   */
  int OP_MULT = 50;

  /**
   * The number of structural features of the '<em>Op Mult</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_MULT_FEATURE_COUNT = OP_MULTIPLICATIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpDivRealImpl <em>Op Div Real</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpDivRealImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpDivReal()
   * @generated
   */
  int OP_DIV_REAL = 51;

  /**
   * The number of structural features of the '<em>Op Div Real</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_DIV_REAL_FEATURE_COUNT = OP_MULTIPLICATIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpModRealImpl <em>Op Mod Real</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpModRealImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpModReal()
   * @generated
   */
  int OP_MOD_REAL = 52;

  /**
   * The number of structural features of the '<em>Op Mod Real</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_MOD_REAL_FEATURE_COUNT = OP_MULTIPLICATIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.OpModIntImpl <em>Op Mod Int</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.OpModIntImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpModInt()
   * @generated
   */
  int OP_MOD_INT = 53;

  /**
   * The number of structural features of the '<em>Op Mod Int</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OP_MOD_INT_FEATURE_COUNT = OP_MULTIPLICATIVE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprSignImpl <em>Expr Sign</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprSignImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprSign()
   * @generated
   */
  int EXPR_SIGN = 54;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SIGN__OP = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SIGN__RIGHT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expr Sign</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SIGN_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprNotImpl <em>Expr Not</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprNotImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprNot()
   * @generated
   */
  int EXPR_NOT = 55;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_NOT__RIGHT = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Not</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_NOT_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprMemberImpl <em>Expr Member</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprMemberImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprMember()
   * @generated
   */
  int EXPR_MEMBER = 56;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MEMBER__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MEMBER__RIGHT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expr Member</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MEMBER_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprIntValImpl <em>Expr Int Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprIntValImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprIntVal()
   * @generated
   */
  int EXPR_INT_VAL = 57;

  /**
   * The feature id for the '<em><b>Int Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_INT_VAL__INT_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Int Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_INT_VAL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprNumValImpl <em>Expr Num Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprNumValImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprNumVal()
   * @generated
   */
  int EXPR_NUM_VAL = 58;

  /**
   * The feature id for the '<em><b>Num Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_NUM_VAL__NUM_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Num Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_NUM_VAL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprStrvalImpl <em>Expr Strval</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprStrvalImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprStrval()
   * @generated
   */
  int EXPR_STRVAL = 59;

  /**
   * The feature id for the '<em><b>Str Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_STRVAL__STR_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Strval</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_STRVAL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprBoolValImpl <em>Expr Bool Val</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprBoolValImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprBoolVal()
   * @generated
   */
  int EXPR_BOOL_VAL = 60;

  /**
   * The feature id for the '<em><b>Bool Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_BOOL_VAL__BOOL_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Bool Val</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_BOOL_VAL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprFuncRefImpl <em>Expr Func Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprFuncRefImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprFuncRef()
   * @generated
   */
  int EXPR_FUNC_REF = 61;

  /**
   * The feature id for the '<em><b>Name Val</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FUNC_REF__NAME_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Func Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FUNC_REF_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprIdentifierImpl <em>Expr Identifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprIdentifierImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprIdentifier()
   * @generated
   */
  int EXPR_IDENTIFIER = 62;

  /**
   * The feature id for the '<em><b>Name Val</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_IDENTIFIER__NAME_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expr Identifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_IDENTIFIER_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.peeeq.pscript.pscript.impl.ExprFunctioncallImpl <em>Expr Functioncall</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.peeeq.pscript.pscript.impl.ExprFunctioncallImpl
   * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprFunctioncall()
   * @generated
   */
  int EXPR_FUNCTIONCALL = 63;

  /**
   * The feature id for the '<em><b>Name Val</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FUNCTIONCALL__NAME_VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FUNCTIONCALL__PARAMETERS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Expr Functioncall</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FUNCTIONCALL_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.Program <em>Program</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Program</em>'.
   * @see de.peeeq.pscript.pscript.Program
   * @generated
   */
  EClass getProgram();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.Program#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see de.peeeq.pscript.pscript.Program#getPackages()
   * @see #getProgram()
   * @generated
   */
  EReference getProgram_Packages();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.PackageDeclaration <em>Package Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Declaration</em>'.
   * @see de.peeeq.pscript.pscript.PackageDeclaration
   * @generated
   */
  EClass getPackageDeclaration();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.PackageDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.peeeq.pscript.pscript.PackageDeclaration#getName()
   * @see #getPackageDeclaration()
   * @generated
   */
  EAttribute getPackageDeclaration_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.PackageDeclaration#getImports <em>Imports</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Imports</em>'.
   * @see de.peeeq.pscript.pscript.PackageDeclaration#getImports()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_Imports();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.PackageDeclaration#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see de.peeeq.pscript.pscript.PackageDeclaration#getElements()
   * @see #getPackageDeclaration()
   * @generated
   */
  EReference getPackageDeclaration_Elements();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see de.peeeq.pscript.pscript.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see de.peeeq.pscript.pscript.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see de.peeeq.pscript.pscript.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.Entity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.peeeq.pscript.pscript.Entity#getName()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Name();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.InitBlock <em>Init Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Init Block</em>'.
   * @see de.peeeq.pscript.pscript.InitBlock
   * @generated
   */
  EClass getInitBlock();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.InitBlock#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.peeeq.pscript.pscript.InitBlock#getBody()
   * @see #getInitBlock()
   * @generated
   */
  EReference getInitBlock_Body();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.TypeDef <em>Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Def</em>'.
   * @see de.peeeq.pscript.pscript.TypeDef
   * @generated
   */
  EClass getTypeDef();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.FuncDef <em>Func Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Func Def</em>'.
   * @see de.peeeq.pscript.pscript.FuncDef
   * @generated
   */
  EClass getFuncDef();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.FuncDef#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.peeeq.pscript.pscript.FuncDef#getParameters()
   * @see #getFuncDef()
   * @generated
   */
  EReference getFuncDef_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.FuncDef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.peeeq.pscript.pscript.FuncDef#getType()
   * @see #getFuncDef()
   * @generated
   */
  EReference getFuncDef_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.FuncDef#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.peeeq.pscript.pscript.FuncDef#getBody()
   * @see #getFuncDef()
   * @generated
   */
  EReference getFuncDef_Body();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ClassMember <em>Class Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Member</em>'.
   * @see de.peeeq.pscript.pscript.ClassMember
   * @generated
   */
  EClass getClassMember();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.VarDef <em>Var Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Def</em>'.
   * @see de.peeeq.pscript.pscript.VarDef
   * @generated
   */
  EClass getVarDef();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.VarDef#isConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constant</em>'.
   * @see de.peeeq.pscript.pscript.VarDef#isConstant()
   * @see #getVarDef()
   * @generated
   */
  EAttribute getVarDef_Constant();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.VarDef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.peeeq.pscript.pscript.VarDef#getType()
   * @see #getVarDef()
   * @generated
   */
  EReference getVarDef_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.VarDef#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see de.peeeq.pscript.pscript.VarDef#getE()
   * @see #getVarDef()
   * @generated
   */
  EReference getVarDef_E();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.TypeExpr <em>Type Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Expr</em>'.
   * @see de.peeeq.pscript.pscript.TypeExpr
   * @generated
   */
  EClass getTypeExpr();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.Statements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statements</em>'.
   * @see de.peeeq.pscript.pscript.Statements
   * @generated
   */
  EClass getStatements();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.Statements#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.peeeq.pscript.pscript.Statements#getStatements()
   * @see #getStatements()
   * @generated
   */
  EReference getStatements_Statements();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see de.peeeq.pscript.pscript.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtExitwhen <em>Stmt Exitwhen</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt Exitwhen</em>'.
   * @see de.peeeq.pscript.pscript.StmtExitwhen
   * @generated
   */
  EClass getStmtExitwhen();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtExitwhen#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see de.peeeq.pscript.pscript.StmtExitwhen#getE()
   * @see #getStmtExitwhen()
   * @generated
   */
  EReference getStmtExitwhen_E();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtLoop <em>Stmt Loop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt Loop</em>'.
   * @see de.peeeq.pscript.pscript.StmtLoop
   * @generated
   */
  EClass getStmtLoop();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtLoop#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.peeeq.pscript.pscript.StmtLoop#getBody()
   * @see #getStmtLoop()
   * @generated
   */
  EReference getStmtLoop_Body();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtReturn <em>Stmt Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt Return</em>'.
   * @see de.peeeq.pscript.pscript.StmtReturn
   * @generated
   */
  EClass getStmtReturn();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtReturn#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see de.peeeq.pscript.pscript.StmtReturn#getE()
   * @see #getStmtReturn()
   * @generated
   */
  EReference getStmtReturn_E();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtIf <em>Stmt If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt If</em>'.
   * @see de.peeeq.pscript.pscript.StmtIf
   * @generated
   */
  EClass getStmtIf();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtIf#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see de.peeeq.pscript.pscript.StmtIf#getCond()
   * @see #getStmtIf()
   * @generated
   */
  EReference getStmtIf_Cond();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtIf#getThenBlock <em>Then Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Block</em>'.
   * @see de.peeeq.pscript.pscript.StmtIf#getThenBlock()
   * @see #getStmtIf()
   * @generated
   */
  EReference getStmtIf_ThenBlock();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.StmtIf#getElseIfConds <em>Else If Conds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Else If Conds</em>'.
   * @see de.peeeq.pscript.pscript.StmtIf#getElseIfConds()
   * @see #getStmtIf()
   * @generated
   */
  EReference getStmtIf_ElseIfConds();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.StmtIf#getElseIfBlocks <em>Else If Blocks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Else If Blocks</em>'.
   * @see de.peeeq.pscript.pscript.StmtIf#getElseIfBlocks()
   * @see #getStmtIf()
   * @generated
   */
  EReference getStmtIf_ElseIfBlocks();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtIf#getElseBlock <em>Else Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Block</em>'.
   * @see de.peeeq.pscript.pscript.StmtIf#getElseBlock()
   * @see #getStmtIf()
   * @generated
   */
  EReference getStmtIf_ElseBlock();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtWhile <em>Stmt While</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt While</em>'.
   * @see de.peeeq.pscript.pscript.StmtWhile
   * @generated
   */
  EClass getStmtWhile();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtWhile#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see de.peeeq.pscript.pscript.StmtWhile#getCond()
   * @see #getStmtWhile()
   * @generated
   */
  EReference getStmtWhile_Cond();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtWhile#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see de.peeeq.pscript.pscript.StmtWhile#getBody()
   * @see #getStmtWhile()
   * @generated
   */
  EReference getStmtWhile_Body();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtSetOrCall <em>Stmt Set Or Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt Set Or Call</em>'.
   * @see de.peeeq.pscript.pscript.StmtSetOrCall
   * @generated
   */
  EClass getStmtSetOrCall();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpAssignment <em>Op Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Assignment</em>'.
   * @see de.peeeq.pscript.pscript.OpAssignment
   * @generated
   */
  EClass getOpAssignment();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see de.peeeq.pscript.pscript.Expr
   * @generated
   */
  EClass getExpr();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpEquality <em>Op Equality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Equality</em>'.
   * @see de.peeeq.pscript.pscript.OpEquality
   * @generated
   */
  EClass getOpEquality();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpComparison <em>Op Comparison</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Comparison</em>'.
   * @see de.peeeq.pscript.pscript.OpComparison
   * @generated
   */
  EClass getOpComparison();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpAdditive <em>Op Additive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Additive</em>'.
   * @see de.peeeq.pscript.pscript.OpAdditive
   * @generated
   */
  EClass getOpAdditive();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpMultiplicative <em>Op Multiplicative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Multiplicative</em>'.
   * @see de.peeeq.pscript.pscript.OpMultiplicative
   * @generated
   */
  EClass getOpMultiplicative();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprList <em>Expr List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr List</em>'.
   * @see de.peeeq.pscript.pscript.ExprList
   * @generated
   */
  EClass getExprList();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.ExprList#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Params</em>'.
   * @see de.peeeq.pscript.pscript.ExprList#getParams()
   * @see #getExprList()
   * @generated
   */
  EReference getExprList_Params();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.NativeFunc <em>Native Func</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Native Func</em>'.
   * @see de.peeeq.pscript.pscript.NativeFunc
   * @generated
   */
  EClass getNativeFunc();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.NativeType <em>Native Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Native Type</em>'.
   * @see de.peeeq.pscript.pscript.NativeType
   * @generated
   */
  EClass getNativeType();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.NativeType#getSuperName <em>Super Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Super Name</em>'.
   * @see de.peeeq.pscript.pscript.NativeType#getSuperName()
   * @see #getNativeType()
   * @generated
   */
  EReference getNativeType_SuperName();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ClassDef <em>Class Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Class Def</em>'.
   * @see de.peeeq.pscript.pscript.ClassDef
   * @generated
   */
  EClass getClassDef();

  /**
   * Returns the meta object for the containment reference list '{@link de.peeeq.pscript.pscript.ClassDef#getMembers <em>Members</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Members</em>'.
   * @see de.peeeq.pscript.pscript.ClassDef#getMembers()
   * @see #getClassDef()
   * @generated
   */
  EReference getClassDef_Members();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.TypeExprRef <em>Type Expr Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Expr Ref</em>'.
   * @see de.peeeq.pscript.pscript.TypeExprRef
   * @generated
   */
  EClass getTypeExprRef();

  /**
   * Returns the meta object for the reference '{@link de.peeeq.pscript.pscript.TypeExprRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.peeeq.pscript.pscript.TypeExprRef#getName()
   * @see #getTypeExprRef()
   * @generated
   */
  EReference getTypeExprRef_Name();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.TypeExprBuildin <em>Type Expr Buildin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Expr Buildin</em>'.
   * @see de.peeeq.pscript.pscript.TypeExprBuildin
   * @generated
   */
  EClass getTypeExprBuildin();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.TypeExprBuildin#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.peeeq.pscript.pscript.TypeExprBuildin#getName()
   * @see #getTypeExprBuildin()
   * @generated
   */
  EAttribute getTypeExprBuildin_Name();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ParameterDef <em>Parameter Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Def</em>'.
   * @see de.peeeq.pscript.pscript.ParameterDef
   * @generated
   */
  EClass getParameterDef();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtCall <em>Stmt Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt Call</em>'.
   * @see de.peeeq.pscript.pscript.StmtCall
   * @generated
   */
  EClass getStmtCall();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtCall#getE <em>E</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>E</em>'.
   * @see de.peeeq.pscript.pscript.StmtCall#getE()
   * @see #getStmtCall()
   * @generated
   */
  EReference getStmtCall_E();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.StmtSet <em>Stmt Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stmt Set</em>'.
   * @see de.peeeq.pscript.pscript.StmtSet
   * @generated
   */
  EClass getStmtSet();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtSet#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.StmtSet#getLeft()
   * @see #getStmtSet()
   * @generated
   */
  EReference getStmtSet_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtSet#getOpAssignment <em>Op Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op Assignment</em>'.
   * @see de.peeeq.pscript.pscript.StmtSet#getOpAssignment()
   * @see #getStmtSet()
   * @generated
   */
  EReference getStmtSet_OpAssignment();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.StmtSet#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.StmtSet#getRight()
   * @see #getStmtSet()
   * @generated
   */
  EReference getStmtSet_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpAssign <em>Op Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Assign</em>'.
   * @see de.peeeq.pscript.pscript.OpAssign
   * @generated
   */
  EClass getOpAssign();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpPlusAssign <em>Op Plus Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Plus Assign</em>'.
   * @see de.peeeq.pscript.pscript.OpPlusAssign
   * @generated
   */
  EClass getOpPlusAssign();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpMinusAssign <em>Op Minus Assign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Minus Assign</em>'.
   * @see de.peeeq.pscript.pscript.OpMinusAssign
   * @generated
   */
  EClass getOpMinusAssign();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprOr <em>Expr Or</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Or</em>'.
   * @see de.peeeq.pscript.pscript.ExprOr
   * @generated
   */
  EClass getExprOr();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprOr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.ExprOr#getLeft()
   * @see #getExprOr()
   * @generated
   */
  EReference getExprOr_Left();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.ExprOr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.peeeq.pscript.pscript.ExprOr#getOp()
   * @see #getExprOr()
   * @generated
   */
  EAttribute getExprOr_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprOr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprOr#getRight()
   * @see #getExprOr()
   * @generated
   */
  EReference getExprOr_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprAnd <em>Expr And</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr And</em>'.
   * @see de.peeeq.pscript.pscript.ExprAnd
   * @generated
   */
  EClass getExprAnd();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprAnd#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.ExprAnd#getLeft()
   * @see #getExprAnd()
   * @generated
   */
  EReference getExprAnd_Left();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.ExprAnd#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see de.peeeq.pscript.pscript.ExprAnd#getOp()
   * @see #getExprAnd()
   * @generated
   */
  EAttribute getExprAnd_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprAnd#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprAnd#getRight()
   * @see #getExprAnd()
   * @generated
   */
  EReference getExprAnd_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprEquality <em>Expr Equality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Equality</em>'.
   * @see de.peeeq.pscript.pscript.ExprEquality
   * @generated
   */
  EClass getExprEquality();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprEquality#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.ExprEquality#getLeft()
   * @see #getExprEquality()
   * @generated
   */
  EReference getExprEquality_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprEquality#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see de.peeeq.pscript.pscript.ExprEquality#getOp()
   * @see #getExprEquality()
   * @generated
   */
  EReference getExprEquality_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprEquality#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprEquality#getRight()
   * @see #getExprEquality()
   * @generated
   */
  EReference getExprEquality_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpEquals <em>Op Equals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Equals</em>'.
   * @see de.peeeq.pscript.pscript.OpEquals
   * @generated
   */
  EClass getOpEquals();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpUnequals <em>Op Unequals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Unequals</em>'.
   * @see de.peeeq.pscript.pscript.OpUnequals
   * @generated
   */
  EClass getOpUnequals();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprComparison <em>Expr Comparison</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Comparison</em>'.
   * @see de.peeeq.pscript.pscript.ExprComparison
   * @generated
   */
  EClass getExprComparison();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprComparison#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.ExprComparison#getLeft()
   * @see #getExprComparison()
   * @generated
   */
  EReference getExprComparison_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprComparison#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see de.peeeq.pscript.pscript.ExprComparison#getOp()
   * @see #getExprComparison()
   * @generated
   */
  EReference getExprComparison_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprComparison#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprComparison#getRight()
   * @see #getExprComparison()
   * @generated
   */
  EReference getExprComparison_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpLessEq <em>Op Less Eq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Less Eq</em>'.
   * @see de.peeeq.pscript.pscript.OpLessEq
   * @generated
   */
  EClass getOpLessEq();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpLess <em>Op Less</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Less</em>'.
   * @see de.peeeq.pscript.pscript.OpLess
   * @generated
   */
  EClass getOpLess();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpGreaterEq <em>Op Greater Eq</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Greater Eq</em>'.
   * @see de.peeeq.pscript.pscript.OpGreaterEq
   * @generated
   */
  EClass getOpGreaterEq();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpGreater <em>Op Greater</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Greater</em>'.
   * @see de.peeeq.pscript.pscript.OpGreater
   * @generated
   */
  EClass getOpGreater();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprAdditive <em>Expr Additive</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Additive</em>'.
   * @see de.peeeq.pscript.pscript.ExprAdditive
   * @generated
   */
  EClass getExprAdditive();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprAdditive#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.ExprAdditive#getLeft()
   * @see #getExprAdditive()
   * @generated
   */
  EReference getExprAdditive_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprAdditive#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see de.peeeq.pscript.pscript.ExprAdditive#getOp()
   * @see #getExprAdditive()
   * @generated
   */
  EReference getExprAdditive_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprAdditive#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprAdditive#getRight()
   * @see #getExprAdditive()
   * @generated
   */
  EReference getExprAdditive_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpPlus <em>Op Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Plus</em>'.
   * @see de.peeeq.pscript.pscript.OpPlus
   * @generated
   */
  EClass getOpPlus();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpMinus <em>Op Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Minus</em>'.
   * @see de.peeeq.pscript.pscript.OpMinus
   * @generated
   */
  EClass getOpMinus();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprMult <em>Expr Mult</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Mult</em>'.
   * @see de.peeeq.pscript.pscript.ExprMult
   * @generated
   */
  EClass getExprMult();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprMult#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.ExprMult#getLeft()
   * @see #getExprMult()
   * @generated
   */
  EReference getExprMult_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprMult#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see de.peeeq.pscript.pscript.ExprMult#getOp()
   * @see #getExprMult()
   * @generated
   */
  EReference getExprMult_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprMult#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprMult#getRight()
   * @see #getExprMult()
   * @generated
   */
  EReference getExprMult_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpMult <em>Op Mult</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Mult</em>'.
   * @see de.peeeq.pscript.pscript.OpMult
   * @generated
   */
  EClass getOpMult();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpDivReal <em>Op Div Real</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Div Real</em>'.
   * @see de.peeeq.pscript.pscript.OpDivReal
   * @generated
   */
  EClass getOpDivReal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpModReal <em>Op Mod Real</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Mod Real</em>'.
   * @see de.peeeq.pscript.pscript.OpModReal
   * @generated
   */
  EClass getOpModReal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.OpModInt <em>Op Mod Int</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Op Mod Int</em>'.
   * @see de.peeeq.pscript.pscript.OpModInt
   * @generated
   */
  EClass getOpModInt();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprSign <em>Expr Sign</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Sign</em>'.
   * @see de.peeeq.pscript.pscript.ExprSign
   * @generated
   */
  EClass getExprSign();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprSign#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see de.peeeq.pscript.pscript.ExprSign#getOp()
   * @see #getExprSign()
   * @generated
   */
  EReference getExprSign_Op();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprSign#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprSign#getRight()
   * @see #getExprSign()
   * @generated
   */
  EReference getExprSign_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprNot <em>Expr Not</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Not</em>'.
   * @see de.peeeq.pscript.pscript.ExprNot
   * @generated
   */
  EClass getExprNot();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprNot#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprNot#getRight()
   * @see #getExprNot()
   * @generated
   */
  EReference getExprNot_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprMember <em>Expr Member</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Member</em>'.
   * @see de.peeeq.pscript.pscript.ExprMember
   * @generated
   */
  EClass getExprMember();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprMember#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see de.peeeq.pscript.pscript.ExprMember#getLeft()
   * @see #getExprMember()
   * @generated
   */
  EReference getExprMember_Left();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprMember#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see de.peeeq.pscript.pscript.ExprMember#getRight()
   * @see #getExprMember()
   * @generated
   */
  EReference getExprMember_Right();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprIntVal <em>Expr Int Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Int Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprIntVal
   * @generated
   */
  EClass getExprIntVal();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.ExprIntVal#getIntVal <em>Int Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Int Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprIntVal#getIntVal()
   * @see #getExprIntVal()
   * @generated
   */
  EAttribute getExprIntVal_IntVal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprNumVal <em>Expr Num Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Num Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprNumVal
   * @generated
   */
  EClass getExprNumVal();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.ExprNumVal#getNumVal <em>Num Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Num Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprNumVal#getNumVal()
   * @see #getExprNumVal()
   * @generated
   */
  EAttribute getExprNumVal_NumVal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprStrval <em>Expr Strval</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Strval</em>'.
   * @see de.peeeq.pscript.pscript.ExprStrval
   * @generated
   */
  EClass getExprStrval();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.ExprStrval#getStrVal <em>Str Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprStrval#getStrVal()
   * @see #getExprStrval()
   * @generated
   */
  EAttribute getExprStrval_StrVal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprBoolVal <em>Expr Bool Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Bool Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprBoolVal
   * @generated
   */
  EClass getExprBoolVal();

  /**
   * Returns the meta object for the attribute '{@link de.peeeq.pscript.pscript.ExprBoolVal#getBoolVal <em>Bool Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Bool Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprBoolVal#getBoolVal()
   * @see #getExprBoolVal()
   * @generated
   */
  EAttribute getExprBoolVal_BoolVal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprFuncRef <em>Expr Func Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Func Ref</em>'.
   * @see de.peeeq.pscript.pscript.ExprFuncRef
   * @generated
   */
  EClass getExprFuncRef();

  /**
   * Returns the meta object for the reference '{@link de.peeeq.pscript.pscript.ExprFuncRef#getNameVal <em>Name Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprFuncRef#getNameVal()
   * @see #getExprFuncRef()
   * @generated
   */
  EReference getExprFuncRef_NameVal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprIdentifier <em>Expr Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Identifier</em>'.
   * @see de.peeeq.pscript.pscript.ExprIdentifier
   * @generated
   */
  EClass getExprIdentifier();

  /**
   * Returns the meta object for the reference '{@link de.peeeq.pscript.pscript.ExprIdentifier#getNameVal <em>Name Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprIdentifier#getNameVal()
   * @see #getExprIdentifier()
   * @generated
   */
  EReference getExprIdentifier_NameVal();

  /**
   * Returns the meta object for class '{@link de.peeeq.pscript.pscript.ExprFunctioncall <em>Expr Functioncall</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr Functioncall</em>'.
   * @see de.peeeq.pscript.pscript.ExprFunctioncall
   * @generated
   */
  EClass getExprFunctioncall();

  /**
   * Returns the meta object for the reference '{@link de.peeeq.pscript.pscript.ExprFunctioncall#getNameVal <em>Name Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name Val</em>'.
   * @see de.peeeq.pscript.pscript.ExprFunctioncall#getNameVal()
   * @see #getExprFunctioncall()
   * @generated
   */
  EReference getExprFunctioncall_NameVal();

  /**
   * Returns the meta object for the containment reference '{@link de.peeeq.pscript.pscript.ExprFunctioncall#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Parameters</em>'.
   * @see de.peeeq.pscript.pscript.ExprFunctioncall#getParameters()
   * @see #getExprFunctioncall()
   * @generated
   */
  EReference getExprFunctioncall_Parameters();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  PscriptFactory getPscriptFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ProgramImpl <em>Program</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ProgramImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getProgram()
     * @generated
     */
    EClass PROGRAM = eINSTANCE.getProgram();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROGRAM__PACKAGES = eINSTANCE.getProgram_Packages();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.PackageDeclarationImpl <em>Package Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.PackageDeclarationImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getPackageDeclaration()
     * @generated
     */
    EClass PACKAGE_DECLARATION = eINSTANCE.getPackageDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DECLARATION__NAME = eINSTANCE.getPackageDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__IMPORTS = eINSTANCE.getPackageDeclaration_Imports();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DECLARATION__ELEMENTS = eINSTANCE.getPackageDeclaration_Elements();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ImportImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.EntityImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.InitBlockImpl <em>Init Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.InitBlockImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getInitBlock()
     * @generated
     */
    EClass INIT_BLOCK = eINSTANCE.getInitBlock();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INIT_BLOCK__BODY = eINSTANCE.getInitBlock_Body();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.TypeDefImpl <em>Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.TypeDefImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeDef()
     * @generated
     */
    EClass TYPE_DEF = eINSTANCE.getTypeDef();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.FuncDefImpl <em>Func Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.FuncDefImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getFuncDef()
     * @generated
     */
    EClass FUNC_DEF = eINSTANCE.getFuncDef();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNC_DEF__PARAMETERS = eINSTANCE.getFuncDef_Parameters();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNC_DEF__TYPE = eINSTANCE.getFuncDef_Type();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNC_DEF__BODY = eINSTANCE.getFuncDef_Body();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ClassMemberImpl <em>Class Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ClassMemberImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getClassMember()
     * @generated
     */
    EClass CLASS_MEMBER = eINSTANCE.getClassMember();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.VarDefImpl <em>Var Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.VarDefImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getVarDef()
     * @generated
     */
    EClass VAR_DEF = eINSTANCE.getVarDef();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_DEF__CONSTANT = eINSTANCE.getVarDef_Constant();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DEF__TYPE = eINSTANCE.getVarDef_Type();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DEF__E = eINSTANCE.getVarDef_E();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.TypeExprImpl <em>Type Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.TypeExprImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeExpr()
     * @generated
     */
    EClass TYPE_EXPR = eINSTANCE.getTypeExpr();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StatementsImpl <em>Statements</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StatementsImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStatements()
     * @generated
     */
    EClass STATEMENTS = eINSTANCE.getStatements();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATEMENTS__STATEMENTS = eINSTANCE.getStatements_Statements();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StatementImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtExitwhenImpl <em>Stmt Exitwhen</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtExitwhenImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtExitwhen()
     * @generated
     */
    EClass STMT_EXITWHEN = eINSTANCE.getStmtExitwhen();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_EXITWHEN__E = eINSTANCE.getStmtExitwhen_E();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtLoopImpl <em>Stmt Loop</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtLoopImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtLoop()
     * @generated
     */
    EClass STMT_LOOP = eINSTANCE.getStmtLoop();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_LOOP__BODY = eINSTANCE.getStmtLoop_Body();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtReturnImpl <em>Stmt Return</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtReturnImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtReturn()
     * @generated
     */
    EClass STMT_RETURN = eINSTANCE.getStmtReturn();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_RETURN__E = eINSTANCE.getStmtReturn_E();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtIfImpl <em>Stmt If</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtIfImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtIf()
     * @generated
     */
    EClass STMT_IF = eINSTANCE.getStmtIf();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_IF__COND = eINSTANCE.getStmtIf_Cond();

    /**
     * The meta object literal for the '<em><b>Then Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_IF__THEN_BLOCK = eINSTANCE.getStmtIf_ThenBlock();

    /**
     * The meta object literal for the '<em><b>Else If Conds</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_IF__ELSE_IF_CONDS = eINSTANCE.getStmtIf_ElseIfConds();

    /**
     * The meta object literal for the '<em><b>Else If Blocks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_IF__ELSE_IF_BLOCKS = eINSTANCE.getStmtIf_ElseIfBlocks();

    /**
     * The meta object literal for the '<em><b>Else Block</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_IF__ELSE_BLOCK = eINSTANCE.getStmtIf_ElseBlock();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtWhileImpl <em>Stmt While</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtWhileImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtWhile()
     * @generated
     */
    EClass STMT_WHILE = eINSTANCE.getStmtWhile();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_WHILE__COND = eINSTANCE.getStmtWhile_Cond();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_WHILE__BODY = eINSTANCE.getStmtWhile_Body();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtSetOrCallImpl <em>Stmt Set Or Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtSetOrCallImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtSetOrCall()
     * @generated
     */
    EClass STMT_SET_OR_CALL = eINSTANCE.getStmtSetOrCall();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpAssignmentImpl <em>Op Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpAssignmentImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpAssignment()
     * @generated
     */
    EClass OP_ASSIGNMENT = eINSTANCE.getOpAssignment();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExpr()
     * @generated
     */
    EClass EXPR = eINSTANCE.getExpr();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpEqualityImpl <em>Op Equality</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpEqualityImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpEquality()
     * @generated
     */
    EClass OP_EQUALITY = eINSTANCE.getOpEquality();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpComparisonImpl <em>Op Comparison</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpComparisonImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpComparison()
     * @generated
     */
    EClass OP_COMPARISON = eINSTANCE.getOpComparison();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpAdditiveImpl <em>Op Additive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpAdditiveImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpAdditive()
     * @generated
     */
    EClass OP_ADDITIVE = eINSTANCE.getOpAdditive();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpMultiplicativeImpl <em>Op Multiplicative</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpMultiplicativeImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMultiplicative()
     * @generated
     */
    EClass OP_MULTIPLICATIVE = eINSTANCE.getOpMultiplicative();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprListImpl <em>Expr List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprListImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprList()
     * @generated
     */
    EClass EXPR_LIST = eINSTANCE.getExprList();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_LIST__PARAMS = eINSTANCE.getExprList_Params();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.NativeFuncImpl <em>Native Func</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.NativeFuncImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getNativeFunc()
     * @generated
     */
    EClass NATIVE_FUNC = eINSTANCE.getNativeFunc();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.NativeTypeImpl <em>Native Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.NativeTypeImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getNativeType()
     * @generated
     */
    EClass NATIVE_TYPE = eINSTANCE.getNativeType();

    /**
     * The meta object literal for the '<em><b>Super Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NATIVE_TYPE__SUPER_NAME = eINSTANCE.getNativeType_SuperName();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ClassDefImpl <em>Class Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ClassDefImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getClassDef()
     * @generated
     */
    EClass CLASS_DEF = eINSTANCE.getClassDef();

    /**
     * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASS_DEF__MEMBERS = eINSTANCE.getClassDef_Members();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.TypeExprRefImpl <em>Type Expr Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.TypeExprRefImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeExprRef()
     * @generated
     */
    EClass TYPE_EXPR_REF = eINSTANCE.getTypeExprRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_EXPR_REF__NAME = eINSTANCE.getTypeExprRef_Name();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.TypeExprBuildinImpl <em>Type Expr Buildin</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.TypeExprBuildinImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getTypeExprBuildin()
     * @generated
     */
    EClass TYPE_EXPR_BUILDIN = eINSTANCE.getTypeExprBuildin();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_EXPR_BUILDIN__NAME = eINSTANCE.getTypeExprBuildin_Name();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ParameterDefImpl <em>Parameter Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ParameterDefImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getParameterDef()
     * @generated
     */
    EClass PARAMETER_DEF = eINSTANCE.getParameterDef();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtCallImpl <em>Stmt Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtCallImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtCall()
     * @generated
     */
    EClass STMT_CALL = eINSTANCE.getStmtCall();

    /**
     * The meta object literal for the '<em><b>E</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_CALL__E = eINSTANCE.getStmtCall_E();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.StmtSetImpl <em>Stmt Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.StmtSetImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getStmtSet()
     * @generated
     */
    EClass STMT_SET = eINSTANCE.getStmtSet();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_SET__LEFT = eINSTANCE.getStmtSet_Left();

    /**
     * The meta object literal for the '<em><b>Op Assignment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_SET__OP_ASSIGNMENT = eINSTANCE.getStmtSet_OpAssignment();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STMT_SET__RIGHT = eINSTANCE.getStmtSet_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpAssignImpl <em>Op Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpAssignImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpAssign()
     * @generated
     */
    EClass OP_ASSIGN = eINSTANCE.getOpAssign();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpPlusAssignImpl <em>Op Plus Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpPlusAssignImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpPlusAssign()
     * @generated
     */
    EClass OP_PLUS_ASSIGN = eINSTANCE.getOpPlusAssign();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpMinusAssignImpl <em>Op Minus Assign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpMinusAssignImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMinusAssign()
     * @generated
     */
    EClass OP_MINUS_ASSIGN = eINSTANCE.getOpMinusAssign();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprOrImpl <em>Expr Or</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprOrImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprOr()
     * @generated
     */
    EClass EXPR_OR = eINSTANCE.getExprOr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_OR__LEFT = eINSTANCE.getExprOr_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPR_OR__OP = eINSTANCE.getExprOr_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_OR__RIGHT = eINSTANCE.getExprOr_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprAndImpl <em>Expr And</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprAndImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprAnd()
     * @generated
     */
    EClass EXPR_AND = eINSTANCE.getExprAnd();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_AND__LEFT = eINSTANCE.getExprAnd_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPR_AND__OP = eINSTANCE.getExprAnd_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_AND__RIGHT = eINSTANCE.getExprAnd_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprEqualityImpl <em>Expr Equality</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprEqualityImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprEquality()
     * @generated
     */
    EClass EXPR_EQUALITY = eINSTANCE.getExprEquality();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_EQUALITY__LEFT = eINSTANCE.getExprEquality_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_EQUALITY__OP = eINSTANCE.getExprEquality_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_EQUALITY__RIGHT = eINSTANCE.getExprEquality_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpEqualsImpl <em>Op Equals</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpEqualsImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpEquals()
     * @generated
     */
    EClass OP_EQUALS = eINSTANCE.getOpEquals();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpUnequalsImpl <em>Op Unequals</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpUnequalsImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpUnequals()
     * @generated
     */
    EClass OP_UNEQUALS = eINSTANCE.getOpUnequals();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprComparisonImpl <em>Expr Comparison</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprComparisonImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprComparison()
     * @generated
     */
    EClass EXPR_COMPARISON = eINSTANCE.getExprComparison();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_COMPARISON__LEFT = eINSTANCE.getExprComparison_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_COMPARISON__OP = eINSTANCE.getExprComparison_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_COMPARISON__RIGHT = eINSTANCE.getExprComparison_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpLessEqImpl <em>Op Less Eq</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpLessEqImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpLessEq()
     * @generated
     */
    EClass OP_LESS_EQ = eINSTANCE.getOpLessEq();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpLessImpl <em>Op Less</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpLessImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpLess()
     * @generated
     */
    EClass OP_LESS = eINSTANCE.getOpLess();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpGreaterEqImpl <em>Op Greater Eq</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpGreaterEqImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpGreaterEq()
     * @generated
     */
    EClass OP_GREATER_EQ = eINSTANCE.getOpGreaterEq();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpGreaterImpl <em>Op Greater</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpGreaterImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpGreater()
     * @generated
     */
    EClass OP_GREATER = eINSTANCE.getOpGreater();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprAdditiveImpl <em>Expr Additive</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprAdditiveImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprAdditive()
     * @generated
     */
    EClass EXPR_ADDITIVE = eINSTANCE.getExprAdditive();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_ADDITIVE__LEFT = eINSTANCE.getExprAdditive_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_ADDITIVE__OP = eINSTANCE.getExprAdditive_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_ADDITIVE__RIGHT = eINSTANCE.getExprAdditive_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpPlusImpl <em>Op Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpPlusImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpPlus()
     * @generated
     */
    EClass OP_PLUS = eINSTANCE.getOpPlus();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpMinusImpl <em>Op Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpMinusImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMinus()
     * @generated
     */
    EClass OP_MINUS = eINSTANCE.getOpMinus();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprMultImpl <em>Expr Mult</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprMultImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprMult()
     * @generated
     */
    EClass EXPR_MULT = eINSTANCE.getExprMult();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_MULT__LEFT = eINSTANCE.getExprMult_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_MULT__OP = eINSTANCE.getExprMult_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_MULT__RIGHT = eINSTANCE.getExprMult_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpMultImpl <em>Op Mult</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpMultImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpMult()
     * @generated
     */
    EClass OP_MULT = eINSTANCE.getOpMult();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpDivRealImpl <em>Op Div Real</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpDivRealImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpDivReal()
     * @generated
     */
    EClass OP_DIV_REAL = eINSTANCE.getOpDivReal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpModRealImpl <em>Op Mod Real</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpModRealImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpModReal()
     * @generated
     */
    EClass OP_MOD_REAL = eINSTANCE.getOpModReal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.OpModIntImpl <em>Op Mod Int</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.OpModIntImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getOpModInt()
     * @generated
     */
    EClass OP_MOD_INT = eINSTANCE.getOpModInt();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprSignImpl <em>Expr Sign</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprSignImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprSign()
     * @generated
     */
    EClass EXPR_SIGN = eINSTANCE.getExprSign();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_SIGN__OP = eINSTANCE.getExprSign_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_SIGN__RIGHT = eINSTANCE.getExprSign_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprNotImpl <em>Expr Not</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprNotImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprNot()
     * @generated
     */
    EClass EXPR_NOT = eINSTANCE.getExprNot();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_NOT__RIGHT = eINSTANCE.getExprNot_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprMemberImpl <em>Expr Member</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprMemberImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprMember()
     * @generated
     */
    EClass EXPR_MEMBER = eINSTANCE.getExprMember();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_MEMBER__LEFT = eINSTANCE.getExprMember_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_MEMBER__RIGHT = eINSTANCE.getExprMember_Right();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprIntValImpl <em>Expr Int Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprIntValImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprIntVal()
     * @generated
     */
    EClass EXPR_INT_VAL = eINSTANCE.getExprIntVal();

    /**
     * The meta object literal for the '<em><b>Int Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPR_INT_VAL__INT_VAL = eINSTANCE.getExprIntVal_IntVal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprNumValImpl <em>Expr Num Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprNumValImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprNumVal()
     * @generated
     */
    EClass EXPR_NUM_VAL = eINSTANCE.getExprNumVal();

    /**
     * The meta object literal for the '<em><b>Num Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPR_NUM_VAL__NUM_VAL = eINSTANCE.getExprNumVal_NumVal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprStrvalImpl <em>Expr Strval</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprStrvalImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprStrval()
     * @generated
     */
    EClass EXPR_STRVAL = eINSTANCE.getExprStrval();

    /**
     * The meta object literal for the '<em><b>Str Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPR_STRVAL__STR_VAL = eINSTANCE.getExprStrval_StrVal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprBoolValImpl <em>Expr Bool Val</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprBoolValImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprBoolVal()
     * @generated
     */
    EClass EXPR_BOOL_VAL = eINSTANCE.getExprBoolVal();

    /**
     * The meta object literal for the '<em><b>Bool Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXPR_BOOL_VAL__BOOL_VAL = eINSTANCE.getExprBoolVal_BoolVal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprFuncRefImpl <em>Expr Func Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprFuncRefImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprFuncRef()
     * @generated
     */
    EClass EXPR_FUNC_REF = eINSTANCE.getExprFuncRef();

    /**
     * The meta object literal for the '<em><b>Name Val</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_FUNC_REF__NAME_VAL = eINSTANCE.getExprFuncRef_NameVal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprIdentifierImpl <em>Expr Identifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprIdentifierImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprIdentifier()
     * @generated
     */
    EClass EXPR_IDENTIFIER = eINSTANCE.getExprIdentifier();

    /**
     * The meta object literal for the '<em><b>Name Val</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_IDENTIFIER__NAME_VAL = eINSTANCE.getExprIdentifier_NameVal();

    /**
     * The meta object literal for the '{@link de.peeeq.pscript.pscript.impl.ExprFunctioncallImpl <em>Expr Functioncall</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.peeeq.pscript.pscript.impl.ExprFunctioncallImpl
     * @see de.peeeq.pscript.pscript.impl.PscriptPackageImpl#getExprFunctioncall()
     * @generated
     */
    EClass EXPR_FUNCTIONCALL = eINSTANCE.getExprFunctioncall();

    /**
     * The meta object literal for the '<em><b>Name Val</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_FUNCTIONCALL__NAME_VAL = eINSTANCE.getExprFunctioncall_NameVal();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_FUNCTIONCALL__PARAMETERS = eINSTANCE.getExprFunctioncall_Parameters();

  }

} //PscriptPackage