package com.toyc.syntax;

/**
 * @ClassName: VarOrArrDefIdTailNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/2
 * @Version 1.0.0
 */
public class VarOrArrDefIdTailNode extends IdTailNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public VarOrArrDefIdTailNode withVarArrayDefNode(VarArrayDefNode defNode){
        this.varArrayDefNode = defNode;
        return this;
    }

    public VarOrArrDefIdTailNode withDefListNode(DeflistNode node){
        this.deflistNode = node;
        return this;
    }

    private VarArrayDefNode varArrayDefNode;
    private DeflistNode deflistNode;
}
