package com.toyc.syntax;

/**
 * @ClassName: AssignTailExprNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/16
 * @Version 1.0.0
 */
public class AssignTailExprNode extends ExprNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public AssignExprNode getAssignExprNode() {
        return assignExprNode;
    }

    void setAssignExprNode(AssignExprNode assignExprNode) {
        this.assignExprNode = assignExprNode;
    }

    private AssignExprNode assignExprNode;
}
