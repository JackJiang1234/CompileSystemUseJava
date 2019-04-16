package com.toyc.syntax;

/**
 * @ClassName: OrTailNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/16
 * @Version 1.0.0
 */
public class OrTailNode extends ExprNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }
}
