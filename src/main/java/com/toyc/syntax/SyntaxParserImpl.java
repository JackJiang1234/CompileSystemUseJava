package com.toyc.syntax;

import com.toyc.lexical.Lexer;
import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.NumToken;
import com.toyc.lexical.token.TagEnum;

import java.util.function.Supplier;

/**
 * @ClassName: SyntaxParserImpl
 * @Description 语法解析默认实现, 使用LL(1)
 * @Author jianyong.jiang
 * @Date 2019/4/4
 * @Version 1.0.0
 */
public class SyntaxParserImpl implements SyntaxParser {

    public SyntaxParserImpl(Lexer lexer) {
        this.lexer = lexer;
        this.moveNext();
    }

    public ProgramNode parse() {
        ProgramNode programNode = new ProgramNode();
        this.program(programNode);

        return programNode;
    }

    // <program> ->	<segment> <program> |  EMPTY
    private void program(ProgramNode programNode) {
        if (lookToken.notEnd()) {
            programNode.addSegment(segment());
            program(programNode);
        }
    }

    // <segment> ->	EXTERN  <type> <def> | <type> <def>
    private SegmentNode segment() {
        SegmentNode segmentNode = new SegmentNode(match(TagEnum.EXTERN));
        segmentNode.setTypeNode(type());
        segmentNode.setDef(def());
        return segmentNode;
    }

    // <type> -> INT ｜ CHAR  |  VOID
    private TypeNode type() {
        this.matchFailException(() -> this.lookToken.isTypeToken(), "expected <type>, but it's " + this.lookToken.getLiteral());
        TypeNode typeNode = new TypeNode(this.lookToken.getTag());
        this.moveNext();
        return typeNode;
    }

    // <def> ->	MUL ID <init> <deflist>  | ID  <idTail>
    private DefNode def() {
        if (this.match(TagEnum.MUL)) {
            this.matchFailException(TagEnum.ID, false, "parse <def> error, expected the token ID, but it's " + this.lookToken.getLiteral());
            PointerDefNode node = new PointerDefNode();
            node.setId(this.lookToken.getLiteral());
            this.moveNext();
            node.setInitNode(init());
            return node;
        }
        if (this.match(TagEnum.ID, false)) {
            NonPointerDefNode node = new NonPointerDefNode();
            node.setId(this.lookToken.getLiteral());
            this.moveNext();
            node.setTailNode(idTail());
            return node;
        }
        throw new SyntaxParsingException(this.prepareMessage("parse <def> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral()));
    }

    // <init> -> ASSIGN <expr> | EMPTY
    private InitNode init() {
        InitNode initNode = new InitNode();
        if (this.match(TagEnum.ASSIGN)) {
            initNode.setExprNode(expr());
            return initNode;
        }
        return null;
    }

    // <idTail>	->	<varrdef><deflist> | LEFT_PARENTHESE <para> RIGHT_PARENTHESE <funtail>
    private IdTailNode idTail() {
        if (this.match(TagEnum.LEFT_PARENTHESE)) {
            FuncIdTailNode idTailNode = new FuncIdTailNode();
            idTailNode.setParaNode(para());
            this.matchFailException(TagEnum.RIGHT_PARENTHESE, "parse <idTail> error, lost right parenthese.");
            idTailNode.setFunTailNode(funTail());
            return idTailNode;
        } else {
            VarArrayIdTailNode idTailNode = new VarArrayIdTailNode();
            idTailNode.setVarArrayDefNode(varArrayDef());
            idTailNode.setDefListNode(defList());
            return idTailNode;
        }
    }

    //  <deflist> -> COMMA <defdata> <deflist> | SEMICOLON
    private DeflistNode defList() {
        if (this.match(TagEnum.SEMICOLON)) {
            return null;
        } else {
            this.matchFailException(TagEnum.COMMA, "parse  <deflist> error. expected COMMA, but it's " + this.lookToken.getLiteral());
            DeflistNode deflistNode = new DeflistNode();
            deflistNode.setDefDataNode(defData());
            deflistNode.setDeflistNode(defList());
            return deflistNode;
        }
    }

    // <defdata> ->	ID <varrdef> | MUL ID  <init>
    private DefDataNode defData() {
        if (this.match(TagEnum.ID, false)) {
            NonPointerDefDataNode nonPointerDefDataNode = new NonPointerDefDataNode();
            nonPointerDefDataNode.setId(this.lookToken.getLiteral());
            this.moveNext();
            nonPointerDefDataNode.setVarDefNode(varArrayDef());
            return nonPointerDefDataNode;
        }
        if (this.match(TagEnum.MUL)) {
            this.matchFailException(TagEnum.ID, false, "parse <defdata> error, expected the token ID, but it's " + this.lookToken.getLiteral());
            PointerDefDataNode pointerDefDataNode = new PointerDefDataNode();
            pointerDefDataNode.setId(this.lookToken.getLiteral());
            this.moveNext();
            pointerDefDataNode.setInitNode(init());
            return pointerDefDataNode;
        }
        throw new SyntaxParsingException(this.prepareMessage("parse <defdata> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral()));
    }

    // <varrdef> ->	LEFT_BRACKET NUM  RIGHT_BRACKET |  <init>
    private VarArrayDefNode varArrayDef() {
        if (this.match(TagEnum.LEFT_BRACKET)) {
            this.matchFailException(TagEnum.NUMBER, false, "parse <varrdef> error. expected the NUMBER.");
            ArrayDefNode defNode = new ArrayDefNode();
            defNode.setNumber(((NumToken) this.lookToken).getValue());
            defNode.setArray(true);
            this.moveNext();
            this.matchFailException(TagEnum.RIGHT_BRACKET, "parse <varrdef> error. expected the RIGHT_BRACKET.");
            return defNode;
        } else {
            InitVarArrayDefNode initVarArrayDefNode = new InitVarArrayDefNode();
            initVarArrayDefNode.setInitNode(init());
            return initVarArrayDefNode;
        }
    }

    // <para>  -> <type> <paradata> <paralist> | _EMPTY
    private ParaNode para() {
        return null;
    }

    // <paradata>		->	MUL ID  |  ID  <paradatatail>
    private void paraData() {

    }

    // <paradatatail>  ->	LEFT_BRACKET   NUMBER   RIGHT_BRACKET  |  _EMPTY
    private void paraDataTail() {

    }

    // <paralist> ->	COMMA  <type>  <paradata>  <paralist> |  _EMPTY
    private void paraList() {

    }

    // <funtail>  -> <block> | SEMICOLON
    private FunTailNode funTail() {
        return null;
    }

    // <block>	->	LEFT_BRACE <subprogram> RIGHT_BRACE
    private void block() {

    }

    // <expr> ->  <assexpr>
    private ExprNode expr() {
        return assignExpr();
    }

    // <assexpr> ->  <orexpr> <asstail>
    private AssignExprNode assignExpr() {
        AssignExprNode assignExprNode = new AssignExprNode();
        assignExprNode.setOrExprNode(orExpr());
        assignExprNode.setAssignTailExprNode(assignTail());
        return assignExprNode;
    }

    private AssignTailExprNode assignTail() {
        AssignTailExprNode node = null;
        if (this.match(TagEnum.ASSIGN)) {
            node = new AssignTailExprNode();
            node.setAssignExprNode(assignExpr());
        }
        return node;
    }

    // <orexpr> ->  <andexpr> <ortail>
    private OrExprNode orExpr() {
        return null;
    }

    private void moveNext() {
        this.lookToken = this.lexer.next();
    }

    private boolean match(TagEnum tagEnum) {
        return this.match(tagEnum, true);
    }

    private boolean match(TagEnum tagEnum, boolean matchMoveToNext) {
        boolean isMatched = this.lookToken.match(tagEnum);
        if (isMatched && matchMoveToNext) {
            this.moveNext();
        }
        return isMatched;
    }

    private void matchFailException(TagEnum tagEnum, String message) {
        this.matchFailException(() -> this.match(tagEnum), message);
    }

    private void matchFailException(TagEnum tagEnum, boolean matchMoveToNext, String message) {
        this.matchFailException(() -> this.match(tagEnum, matchMoveToNext), message);
    }

    private void matchFailException(Supplier<Boolean> supplier, String message) {
        if (!supplier.get()) {
            throw new SyntaxParsingException(this.prepareMessage(message));
        }
    }

    private String prepareMessage(String message) {
        return message + String.format(" line %d, col %d.", this.lexer.getLine(), this.lexer.getCol());
    }

    private Lexer lexer;
    private BaseToken lookToken;
}
