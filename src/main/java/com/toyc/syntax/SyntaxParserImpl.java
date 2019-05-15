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
     * <p>
     * return parameters
     */
    private void parseParameter() {
        this.parseType();
        this.parseParameterData();
        this.parseParameterList();
    }

    /**
     * 解析单个参数内容
     * <paradata>  ->	MUL ID  |  ID  <paraarray>
     * <p>
     * 普通参数解析
     * parameter.id = get_id()
     * parameter.isPointer = is_pointer()
     * <p>
     * 数组参数解析
     * parameter.arrayName = get_id()
     * parameter.isArray = true
     * parameter.arraySize = paraarray.size()
     * <p>
     * return parameter
     */
    private void parseParameterData() {
        this.parseParameterArraySize();
    }

    // <init> -> ASSIGN <expr> | EMPTY
    private void parseInit() {
        if (this.match(Tag.ASSIGN)) {
            this.parseExpr();
        }
    }

    /**
     * 解析数组参数大小
     * <paraarray>  ->	LEFT_BRACKET   NUMBER   RIGHT_BRACKET  |  ∈
     * <p>
     * return get_array_size()
     */
    private void parseParameterArraySize() {

    }

    /**
     * 解析首个声明或定义变量后的参数列表
     * <paralist> -> COMMA <type> <paradata> <paralist> |  ∈
     * <p>
     * <p>
     * var.type = type.type
     * var.id =   paradata.id
     * var.ispointer = paradata.ispointer
     * var.isarray = paradata.isarray
     * parent.varlist.add(var)
     * return parent.varlist
     */
    private void parseParameterList() {

    }

    /**
     * 解析函数定义或确定是否声明
     * <funtail>  -> <block> | SEMICOLON
     * <p>
     * 解析是否声明
     * function.is_declare = get_is_delcare()
     * <p>
     * 解析函数方法体
     * block.returntype = parent.type
     * block.paraemters = parent.parameters
     * function.bodycode = block.code;
     * <p>
     * return function;
     */

    private void parseFunTail() {
        this.parseBlock();
    }

    /**
     * 解析函数语句块入口
     * <block>	-> LEFT_BRACE <sequence> RIGHT_BRACE
     * sequence.returntype = parent.type
     * sequence.paraemters = parent.parameters
     * return sequence.code
     */
    private void parseBlock() {
        this.parseSequence();
    }

    /**
     * 解析函数语句块
     * <sequence>	->	<localdef> <sequence> | <statement> <sequence>  | ∈
     * <p>
     * 解析局部变量定义
     * sequence.code = localdef.code
     * <p>
     * 解析语句块
     * statment.type = localdef.type
     * statment.id = localdef.id
     * sequence.code = statement.code
     * <p>
     * return sequence.code
     */
    private void parseSequence() {
        this.parseLocalDef();
    }

    /**
     * 解析局部变量定义
     * <localdef>  ->  <type> <defdata> <deflist>
     * <p>
     * localdef.code = new list()
     * defdata.type = type.type
     * localdef.code.add(defdata.code)
     * <p>
     * deflist.type = type.type
     * localdef.code.add(deflist.code)
     * <p>
     * return localdef.code
     */
    private void parseLocalDef() {

    }

    /**
     * 解析语句
     * <statement>  -> <altexpr> SEMICOLON | <whilestat>| <forstat> | <dowhilestat> | <ifstat> | <switchstat> | BREAK SEMICOLON | CONTINE SEMICOLON | RETURN <altexpr> SEMICOLON
     * <p>
     * 赋值或空语句 <altexpr> SEMICOLON
     * statement.type = parent.type
     * statement.id = parent.id
     * statement.code = altexpr.code
     * <p>
     * while语句 <whilestat>
     * statement.code = whilestat.code
     * <p>
     * for语句 <forstat>
     * statement.code = forstat.code
     * <p>
     * dowhile语句 <dowhilestat>
     * statement.code = dowhilestat.code
     * <p>
     * if语句 <ifstat>
     * statement.code = if.code
     * <p>
     * switch语句 <switchstat>
     * statement.code = switchstat.code
     * <p>
     * break语句 BREAK SEMICOLON
     * statement.code = break.code
     * <p>
     * contine语句 CONTINE SEMICOLON
     * statement.code = continue.code
     * <p>
     * return 语句 RETURN <altexpr> SEMICOLON
     * statement.code = return.code
     * <p>
     * return statement.code
     */
    private void parseStatment() {
        this.parseAltExpr();
        this.parseWhile();
        this.parseFor();
        this.parseDoWhile();
        this.parseIf();
        this.parseSwitch();
    }

    /**
     * 解析while语句
     * <whilestat> ->  WHILE  LEFT_PARENTHESE  <altexpr> RIGHT_PARENTHESE <block>
     * whilestat.code = new list;
     * whilestat.code.add(altexpr.code)
     * whilestat.code.add(block.code);
     * <p>
     * return whilestat.code
     */
    private void parseWhile() {

    }

    /**
     * 解析for语句
     * <forstat> -> FOR LEFT_PARENTHESE  <forinit> SEMICOLON <altexpr> SEMICOLON <altexpr> RIGHT_PARENTHESE <block>
     */
    private void parseFor() {

    }

    /**
     * 解析for初始化
     * <forinit>  ->  <localdef> | <altexpr>
     */
    private void parseForInit() {

    }

    /**
     * 解析do while语句
     * <dowhilestat> -> DO <block> WHILE LEFT_PARENTHESE  <altexpr> RIGHT_PARENTHESE
     */
    private void parseDoWhile() {

    }

    /**
     * 解析if
     * <ifstat>	 ->  IF LEFT_PARENTHESE  <expr> RIGHT_PARENTHESE  <block> <elsestat>
     */
    private void parseIf() {
        this.parseElse();
    }

    /**
     * 解析else
     * <elsestat>		-> 	ELSE <block> | ∈
     */
    private void parseElse() {

    }

    /**
     * 解析switch
     * <switchstat>	-> 	SWITCH  LEFT_PARENTHESE  <expr> RIGHT_PARENTHESE  LEFT_BRACE <casestat>
     */
    private void parseSwitch() {

    }

    /**
     * 解析case
     * <casestat> ->  CASE <caselabel> COLON <subprogram><casestat> | DEFAULT COLON
     */
    private void parseCase() {
        this.parseLiteral();
    }


    /**
     * 解析可为空表达式
     * <altexpr>  ->  <expr> |  ∈
     * <p>
     * expr.type = parent.type
     * expr.id = parent.id
     * return expr.code
     */
    private void parseAltExpr() {
        this.parseExpr();
    }

    /**
     * 解析表达式
     * <expr> -> <assexpr>
     */
    private void parseExpr() {
        this.parseAssignExpr();
    }

    /**
     * 解析赋值表达式, 赋值表达式优化级最低
     * <assexpr>  -> <orexpr> <asstail>
     */
    private void parseAssignExpr() {
        this.parseAssignTail();
    }

    /**
     * 解析赋值右值
     * <asstail>  ->   ASSIGN <assexpr>| ∈
     */
    private void parseAssignTail() {
        this.parseOrExpr();
    }

    /**
     * 解析Or表达式
     * <orexpr>  ->  <andexpr> <ortail>
     * */
    private void parseOrExpr() {
        this.parseAndExpr();
    }

    /**
     * 解析Or表达式右部
     * <ortail>  ->  OR <andexpr> <ortail> | ∈
     * */
    private void parseOrTail(){

    }

    /**
     * 解析And表达式
     * <andexpr>  ->   <cmpexpr> <andtail>
     * */
    private void parseAndExpr(){
        this.parseAndTail();
    }

    /**
     * 解析And表达式右部
     * <andtail>       ->  AND  <cmpexpr> <andtail> | ∈
     * */
    private void parseAndTail(){
        this.parseCompareExpr();
    }

    /**
     * 解析关系表达式
     * <cmpexpr>  ->  <aloexpr><cmptail>
     * */
    private void parseCompareExpr(){
        this.parseCompareTail();
    }

    /**
     * 解析关系表达式右部
     * <cmptail>  ->  <cmps> <aloexpr> <cmptail> | ∈
     * */
    private void parseCompareTail(){
        this.parseComparetor();
        this.parseArithmeticExpr();
    }

    /**
     *  解析关系运算符
     * <cmps>->  GT |  GTE |  LT |  LTE | EQU | NOT_EQU
     *
     * */
    private void parseComparetor(){

    }

    /**
     *  解析算术运算表达式
     * <aloexpr>  ->  <item> <alotail>
     *
     * */
    private void parseArithmeticExpr(){
        this.parseArithmeticExprTail();
    }

    /**
     *  解析算术运算表达式右部
     *  <alotail>  ->  <adds> <item> <alotail> | ∈
     * */
    private void parseArithmeticExprTail(){

    }

    /**
     * 解析加或减运算符
     * <adds>  ->  PLUS | MINUS
     * */
    private void parseAdd(){

    }

    /**
     *  解析算述运算项
     * <item>  ->  <factor> <itemtail>
     * 
     * */
    private void parseItem(){

    }

    /**
     * 解析字面量
     * <literal>  -> NUMBER | STRING | CHARACTER
     */
    private void parseLiteral() {

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
