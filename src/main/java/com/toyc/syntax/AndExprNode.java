package com.toyc.syntax;

/**
 * @ClassName: AndExprNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/16
 * @Version 1.0.0
 */
public class AndExprNode extends ExprNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }
}
