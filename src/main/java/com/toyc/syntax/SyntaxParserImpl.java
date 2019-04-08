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

    private void program(ProgramNode programNode) {
        if (lookToken.notEnd()){
            segment(programNode);
            program(programNode);
        }
    }

    private void segment(ProgramNode programNode){
        SegmentNode segmentNode = new SegmentNode(match(TagEnum.EXTERN));


        programNode.addSegment(segmentNode);
    }

    private TypeNode type(){
        return null;
    }

    private void move() {
        this.lookToken = this.lexer.next();
    }

    private boolean match(TagEnum tagEnum){
        return this.lookToken.match(tagEnum);
    }

    private Lexer lexer;
    private BaseToken lookToken;
}
