package com.toyc.syntax;

import com.toyc.lexical.Lexer;
import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.TagEnum;

import java.util.function.Supplier;

/**
 * @ClassName: SyntaxParserImpl
 * @Description 语法解析默认实现, 算法LL(1)
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
            segment(programNode);
            program(programNode);
        }
    }

    // <segment> ->	EXTERN  <type> <def> | <type> <def>
    private void segment(ProgramNode programNode) {
        SegmentNode segmentNode = new SegmentNode(match(TagEnum.EXTERN));
        segmentNode.addTypeNode(type());
        segmentNode.addDef(def());
        programNode.addSegment(segmentNode);
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
            node.addId(this.lookToken.getLiteral());
            this.moveNext();
            node.addInitNode(init());
            return node;
        }
        if (this.match(TagEnum.ID, false)) {
            NonPointerDefNode node = new NonPointerDefNode();
            node.addId(this.lookToken.getLiteral());
            this.moveNext();
            node.addTailNode(idTail());
            return node;
        }
        throw new SyntaxParsingException(this.prepareMessage("parse <def> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral()));
    }

    // <init> -> ASSIGN <expr> | EMPTY
    private InitNode init() {
        return null;
    }

    // <idTail>	->	<varrdef><deflist> | LEFT_PARENTHESE <para> RIGHT_PARENTHESE <funtail>
    private IdTailNode idTail() {
        if (this.match(TagEnum.LEFT_PARENTHESE)) {
            FuncIdTailNode idTailNode = new FuncIdTailNode();
            idTailNode.addParaNode(para());
            //if (this.match(TagEnum.RIGHT_PARENTHESE))
            return idTailNode;
        }
        varArrayDef();
        defList();
        this.match(TagEnum.SEMICOLON);
        return null;
    }

    //  <deflist> -> COMMA <defdata> <deflist> | SEMICOLON
    private void defList() {

    }

    // <defdata> ->	ID <varrdef> | MUL ID  <init>
    private void defData() {
    }

    // <varrdef> ->	LEFT_BRACKET NUM  RIGHT_BRACKET |  <init>
    private void varArrayDef() {

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
    private void funTail() {

    }

    // <block>	->	LEFT_BRACE <subprogram> RIGHT_BRACE
    private void block() {

    }

    // <expr> ->  <assexpr>
    private void expr() {
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
