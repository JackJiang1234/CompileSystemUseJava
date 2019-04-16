package com.toyc.syntax;

/**
 * @ClassName: OrExprNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/16
 * @Version 1.0.0
 */
public class OrExprNode extends ExprNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    private AndExprNode andExprNode;
    private OrTailNode orTailNode;
}
