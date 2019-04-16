package com.toyc.syntax;

/**
 * @ClassName: AssignExprNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/16
 * @Version 1.0.0
 */
public class AssignExprNode extends ExprNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public OrExprNode getOrExprNode() {
        return orExprNode;
    }

    public AssignTailExprNode getAssignTailExprNode() {
        return assignTailExprNode;
    }

    void setOrExprNode(OrExprNode orExprNode) {
        this.orExprNode = orExprNode;
    }

    void setAssignTailExprNode(AssignTailExprNode assignTailExprNode) {
        this.assignTailExprNode = assignTailExprNode;
    }

    private OrExprNode orExprNode;
    private AssignTailExprNode assignTailExprNode;
}
