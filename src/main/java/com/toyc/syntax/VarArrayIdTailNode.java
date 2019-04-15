package com.toyc.syntax;

/**
 * @ClassName: VarArrayIdTailNode
 * @Description 变量或数组定义
 * @Author jianyong.jiang
 * @Date 2019/4/2
 * @Version 1.0.0
 */
public class VarArrayIdTailNode extends IdTailNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    void setVarArrayDefNode(VarArrayDefNode defNode) {
        this.varArrayDefNode = defNode;
    }

    void setDefListNode(DeflistNode node) {
        this.deflistNode = node;
    }

    public VarArrayDefNode getVarArrayDefNode() {
        return this.varArrayDefNode;
    }

    public DeflistNode getDeflistNode() {
        return this.deflistNode;
    }

    private VarArrayDefNode varArrayDefNode;
    private DeflistNode deflistNode;
}
