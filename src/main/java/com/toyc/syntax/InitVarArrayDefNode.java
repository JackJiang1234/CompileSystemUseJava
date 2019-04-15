package com.toyc.syntax;

/**
 * @ClassName: InitVarArrayDefNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class InitVarArrayDefNode extends VarArrayDefNode {

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    void setInitNode(InitNode node) {
        this.initNode = node;
    }

    public InitNode getInitNode() {
        return this.initNode;
    }

    private InitNode initNode;
}
