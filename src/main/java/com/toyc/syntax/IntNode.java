package com.toyc.syntax;

/**
 * @ClassName: IntNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class IntNode extends TypeNode {

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }
}
