package com.toyc.syntax;

/**
 * @ClassName: InitVarDefNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class InitVarDefNode extends VarDefNode {

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public InitVarDefNode withInitNode(InitNode node) {
        this.initNode = node;
        return this;
    }

    public InitNode getInitNode() {
        return this.initNode;
    }

    private InitNode initNode;
}
