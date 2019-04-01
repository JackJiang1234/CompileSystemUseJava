package com.toyc.syntax;

/**
 * @ClassName: NumNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class NumNode extends SyntaxNode {

    public NumNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    private int value;
}
