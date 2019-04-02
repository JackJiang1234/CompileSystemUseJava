package com.toyc.syntax;

/**
 * @ClassName: ArrayDefNode
 * @Description 数组定义
 * 产生式: LEFT_BRACKET NUM  RIGHT_BRACKET
 * 隐式包含[和]
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class ArrayDefNode extends VarArrayDefNode {

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public ArrayDefNode withNumNode(NumNode node){
        this.numNode = node;
        return this;
    }

    private NumNode numNode;
}
