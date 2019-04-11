package com.toyc.syntax;

import com.toyc.lexical.Lexer;
import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.TagEnum;

/**
 * @ClassName: SyntaxParserImpl
 * @Description 语法解析默认实现,算法LL(1)
 * @Author jianyong.jiang
 * @Date 2019/4/4
 * @Version 1.0.0
 */
public class SyntaxParserImpl implements SyntaxParser {

    public SyntaxParserImpl(Lexer lexer) {
        this.lexer = lexer;
        this.moveNext();
    }

    @Override
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
        if (this.lookToken.isTypeToken()) {
            TypeNode typeNode = new TypeNode(this.lookToken.getTag());
            this.moveNext();
            return typeNode;
        } else {
            throw new SyntaxParsingException("expected <type>, but it's " + this.lookToken.getLiteral());
        }
    }

    // <def> ->	MUL ID <init> <deflist>  | ID  <idtail>
    private DefNode def() {
        if (this.match(TagEnum.MUL)) {
            if (this.match(TagEnum.ID, false)) {
                PointerDefNode node = new PointerDefNode();
                node.addId(this.lookToken.getLiteral());
                this.moveNext();
                node.addInitNode(init());
                return node;
            } else {
                throw new SyntaxParsingException("parse <def> error, expected the token ID, but it's " + this.lookToken.getLiteral());
            }
        }
        if (this.match(TagEnum.ID, false)) {
            NonPointerDefNode node = new NonPointerDefNode();
            node.addId(this.lookToken.getLiteral());
            this.moveNext();
            node.addTailNode(idtail());
            return node;
        }
        throw new SyntaxParsingException("parse <def> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral());
    }

    // <init> -> ASSIGN <expr> | EMPTY
    private InitNode init(){
        return null;
    }

    // <idtail>	->	<varrdef><deflist> | LEFT_PARENTHESE <para> RIGHT_PARENTHESE <funtail>
    private IdTailNode idtail(){
        this.match(TagEnum.SEMICOLON);
        return null;
    }

    private void varArrayDef(){

    }

    private void deflist(){

    }

    private void para(){

    }

    private void funtail(){

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

    private Lexer lexer;
    private BaseToken lookToken;
}
