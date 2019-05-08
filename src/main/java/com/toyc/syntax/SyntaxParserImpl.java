package com.toyc.syntax;

import com.toyc.lexical.Lexer;
import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.Tag;

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

    public void parse() {

    }

    // <program> ->	<segment> <program> |  EMPTY
    private void parseProgram() {
        if (lookToken.notEnd()) {
            parseSegment();
        }
    }

    // <segment> ->	EXTERN  <type> <def> | <type> <def>
    private void parseSegment() {
        match(Tag.EXTERN);
        parseType();
        parseDef();
    }

    // <type> -> INT ｜ CHAR  |  VOID
    private void parseType() {
        this.matchFailException(() -> this.lookToken.isTypeToken(), "expected <type>, but it's " + this.lookToken.getLiteral());
    }

    // <def> ->	MUL ID <init> <deflist>  | ID  <idTail>
    private void parseDef() {
        if (this.match(Tag.MUL)) {
            this.matchFailException(Tag.ID, false, "parse <def> error, expected the token ID, but it's " + this.lookToken.getLiteral());
            this.parseInit();
            this.parseDefList();
        }
        if (this.match(Tag.ID, false)) {
            this.parseIdTail();
        }
        throw new SyntaxParsingException(this.prepareMessage("parse <def> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral()));
    }

    // <init> -> ASSIGN <expr> | EMPTY
    private void parseInit() {
        if (this.match(Tag.ASSIGN)) {
            this.parseExpr();
        }
    }

    // <idTail>	->	<varrdef><deflist> | LEFT_PARENTHESE <para> RIGHT_PARENTHESE <funtail>
    private void parseIdTail() {
        if (this.match(Tag.LEFT_PARENTHESE)) {

        } else {

        }
    }

    //  <deflist> -> COMMA <defdata> <deflist> | SEMICOLON
    private void parseDefList() {
        while (match(Tag.COMMA)) {
            parseDefData();
        }
        match(Tag.SEMICOLON);
    }

    // <defdata> ->	ID <varrdef> | MUL ID  <init>
    private void parseDefData() {
        if (this.match(Tag.ID, false)) {
            this.parseVarArrayDef();
        }
        if (this.match(Tag.MUL)) {
            this.matchFailException(Tag.ID, false, "parse <defdata> error, expected the token ID, but it's " + this.lookToken.getLiteral());
            this.parseInit();
        }
        throw new SyntaxParsingException(this.prepareMessage("parse <defdata> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral()));
    }

    // <varrdef> ->	LEFT_BRACKET NUM  RIGHT_BRACKET |  <init>
    private void parseVarArrayDef() {
        if (this.match(Tag.LEFT_BRACKET)) {
            this.matchFailException(Tag.NUMBER, false, "parse <varrdef> error. expected the NUMBER.");

            this.moveNext();
            this.matchFailException(Tag.RIGHT_BRACKET, "parse <varrdef> error. expected the RIGHT_BRACKET.");

        } else {
            this.parseInit();
        }
    }

    // <para>  -> <type> <paradata> <paralist> | _EMPTY
    private void parseParameter() {
        parseType();

    }

    // <paradata>		->	MUL ID  |  ID  <paradatatail>
    private void parseParameterData() {

    }

    // <paradatatail>  ->	LEFT_BRACKET   NUMBER   RIGHT_BRACKET  |  _EMPTY
    private void parseParameterDataTail() {

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
    private void parseExpr() {

    }

    // <assexpr> ->  <orexpr> <asstail>
    private void assignExpr() {

    }

    private void assignTail() {

    }

    // <orexpr> ->  <andexpr> <ortail>
    private void orExpr() {

    }

    private void moveNext() {
        this.lookToken = this.lexer.next();
    }

    private boolean match(Tag tag) {
        return this.match(tag, true);
    }

    private boolean match(Tag tag, boolean matchMoveToNext) {
        boolean isMatched = this.lookToken.match(tag);
        if (isMatched && matchMoveToNext) {
            this.moveNext();
        }
        return isMatched;
    }

    private void matchFailException(Tag tag, String message) {
        this.matchFailException(() -> this.match(tag), message);
    }

    private void matchFailException(Tag tag, boolean matchMoveToNext, String message) {
        this.matchFailException(() -> this.match(tag, matchMoveToNext), message);
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
