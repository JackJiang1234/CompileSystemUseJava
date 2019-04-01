package com.toyc.syntax;

/**
 * @ClassName: NonPointerDefDataNode
 * @Description ID <vardef>
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class NonPointerDefDataNode extends DefDataNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public NonPointerDefDataNode withIdNode(IdNode idNode) {
        this.idNode = idNode;
        return this;
    }

    public NonPointerDefDataNode withVarDefNode(VarDefNode node) {
        this.varDefNode = node;
        return this;
    }

    private IdNode idNode;
    private VarDefNode varDefNode;
}
