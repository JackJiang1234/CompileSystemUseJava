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

    public void setId(String id) {
        this.id = id;
    }

    public void setVarDefNode(VarArrayDefNode node) {
        this.varArrayDefNode = node;
    }

    private String id;
    private VarArrayDefNode varArrayDefNode;
}
