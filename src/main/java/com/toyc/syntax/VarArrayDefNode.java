package com.toyc.syntax;

/**
 * @ClassName: VarArrayDefNode
 * @Description 数组或变量赋值定义
 * <varrdef> ->	LEFT_BRACKET NUM  RIGHT_BRACKET |  <init>
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public abstract class VarArrayDefNode extends SyntaxNode {
    public boolean isArray() {
        return this.isArray;
    }
    void setArray(boolean isArray) {
        this.isArray = isArray;
    }

    private boolean isArray;
}
