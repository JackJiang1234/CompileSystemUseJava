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

    /**
     * 程序语法解析入口
     * <program> -> <segment> <program> | ∈
     * 收集语句序列，以便后续中间代码和目标代码生成
     * prgram.code = segment.code + segment.code + ...
     * return program.code
     */
    private void parseProgram() {
        if (lookToken.notEnd()) {
            parseSegment();
        }
    }

    /**
     * 解析程序段
     * <segment> -> <type> <defcontent>
     * 程序段由变量或函数声明和定义组成
     * defcontent.type = type.type
     * return defcontent.code
     */
    private void parseSegment() {
        parseType();
        parseDefContent();
    }

    /**
     * 解析类型
     * <type> -> INT ｜ CHAR  |  VOID
     * return type
     */
    private void parseType() {
        this.matchFailException(() -> this.lookToken.isTypeToken(), "expected <type>, but it's " + this.lookToken.getLiteral());
    }

    /**
     * 解析变量或函数声明或定义内容, 声明或定义可能以指针开头
     * <defcontent> ->	MUL ID <init> <deflist>  | ID  <idTail>
     * <p>
     * 指针变量声明或定义处理
     * init.id = get_id()
     * init.ispointer = test_pointer()
     * init.type = parent.type
     * deflist.type = parent.type
     * defcontent.code = init.code + deflist.code
     * <p>
     * 普通变量声明或定义处理
     * idtail.id = get_id()
     * idtail.type = parent.type
     * defconent.code = idtail.code;
     * <p>
     * return defcontent.code
     */
    private void parseDefContent() {
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

    /**
     * 解析多个变量定义
     * <deflist> -> COMMA <defdata> <deflist> | SEMICOLON
     * defdata.type = parent.type
     * deflist.code = defdata.code + defdata.code + ...
     */
    private void parseDefList() {
        while (match(Tag.COMMA)) {
            parseDefData();
        }
        match(Tag.SEMICOLON);
    }

    /**
     * 解析变量定义内容
     * <defdata> -> ID <var_or_array_init> | MUL ID  <init>
     * <p>
     * 数组或普通变量定义
     * var_or_array_init.id = get_id()
     * var_or_array_init.type = parent.type
     * defdata.code = var_or_array_init.code
     * <p>
     * 指针变量定义
     * init.id = get_id()
     * init.type = parent.type
     * init.ispointer = test_pointer()
     * defdata.code = init.code
     * <p>
     * return defdata.code
     */
    private void parseDefData() {
        if (this.match(Tag.ID, false)) {
            this.parseVarOrArrayInit();
        }
        if (this.match(Tag.MUL)) {
            this.matchFailException(Tag.ID, false, "parse <defdata> error, expected the token ID, but it's " + this.lookToken.getLiteral());
            this.parseInit();
        }
        throw new SyntaxParsingException(this.prepareMessage("parse <defdata> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral()));
    }

    /**
     * 解析数组或变量初始化
     * <var_or_array_init> -> LEFT_BRACKET NUM  RIGHT_BRACKET |  <init>
     * <p>
     * 数组解析
     * array.elementType = parent.type
     * array.size = getNum()
     * var_or_array_init.code = array.code
     * <p>
     * 初始化解析
     * init.id = parent.id
     * init.type = parent.type
     * init.ispointer = parent.isporinter
     * var_or_array_init.code = init.code
     * <p>
     * return var_or_array_init.code
     */
    private void parseVarOrArrayInit() {
        if (this.match(Tag.LEFT_BRACKET)) {
            this.matchFailException(Tag.NUMBER, false, "parse <varrdef> error. expected the NUMBER.");

            this.moveNext();
            this.matchFailException(Tag.RIGHT_BRACKET, "parse <varrdef> error. expected the RIGHT_BRACKET.");

        } else {
            this.parseInit();
        }
    }

    /**
     * 解析普通变量和函数声明或定义
     * <idTail> ->	<var_or_array_init> <deflist> | LEFT_PARENTHESE <para> RIGHT_PARENTHESE <funtail>
     * <p>
     * 普通变量解析
     * var_or_array_init.id = parent.id
     * var_or_array_init.type = parent.type
     * deflist.type = parent.type
     * idtail.code = var_or_array_init.code + deflist.code
     * <p>
     * 函数解析
     * funtail.parameters = para.parameters
     * funtail.returntype = parent.type
     * idtail.code = funtail.code
     */
    private void parseIdTail() {
        if (this.match(Tag.LEFT_PARENTHESE)) {
            this.parseParameter();
            this.match(Tag.RIGHT_PARENTHESE);
            this.parseFunTail();
        } else {

        }
    }

    /**
     * 解析函数参数列表
     * <para>  -> <type> <paradata> <paralist> | ∈
     * paradata.type = type.type
     * parameters.add(paradata.parameter)
     * parameters.add(paralist.parameters)
     *
     * return parameters
     */
    private void parseParameter() {
        parseType();

    }

    // <init> -> ASSIGN <expr> | EMPTY
    private void parseInit() {
        if (this.match(Tag.ASSIGN)) {
            this.parseExpr();
        }
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
    private void parseFunTail() {

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
