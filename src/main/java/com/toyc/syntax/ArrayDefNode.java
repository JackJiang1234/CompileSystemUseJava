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

    void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private int number;
}
