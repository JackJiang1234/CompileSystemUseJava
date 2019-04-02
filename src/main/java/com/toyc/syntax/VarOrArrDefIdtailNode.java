package com.toyc.syntax;

/**
 * @ClassName: VarOrArrDefIdtailNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/2
 * @Version 1.0.0
 */
public class VarOrArrDefIdtailNode extends IdtailNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public VarOrArrDefIdtailNode withVarArrayDefNode(VarArrayDefNode defNode){
        this.varArrayDefNode = defNode;
        return this;
    }

    public VarOrArrDefIdtailNode withDefListNode(DeflistNode node){
        this.deflistNode = node;
        return this;
    }

    private VarArrayDefNode varArrayDefNode;
    private DeflistNode deflistNode;
}
