package com.toyc.syntax;

import com.toyc.lexical.Lexer;
import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.TagEnum;

/**
 * @ClassName: SyntaxParserImpl
 * @Description 语法解析默认实现
 * @Author jianyong.jiang
 * @Date 2019/4/4
 * @Version 1.0.0
 */
public class SyntaxParserImpl implements SyntaxParser {

    public SyntaxParserImpl(Lexer lexer) {
        this.lexer = lexer;
        this.move();
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
            this.move();
            return typeNode;
        } else {
            throw new SyntaxParsingException("unknown type " + this.lookToken.getLiteral());
        }
    }

    // <def> ->	MUL ID <init> <deflist>  | ID  <idtail>
    private DefNode def() {
        DefNode node;
        String id;
        if (this.match(TagEnum.MUL)) {
            node = new PointerDefNode();
            if (this.match(TagEnum.ID)) {
                id = this.lookToken.getLiteral();
            } else {
                throw new SyntaxParsingException("");
            }

            return node;
        }
        if (this.match(TagEnum.ID)) {
            node = new NonPointerDefNode();
        }
        throw new SyntaxParsingException("parse <def> error, expected the token MUL or ID, but it's " + this.lookToken.getLiteral());
    }

    private void move() {
        this.lookToken = this.lexer.next();
    }

    private boolean match(TagEnum tagEnum) {
        if (this.lookToken.match(tagEnum)) {
            move();
            return true;
        } else {
            return false;
        }
    }

    private Lexer lexer;
    private BaseToken lookToken;
}
