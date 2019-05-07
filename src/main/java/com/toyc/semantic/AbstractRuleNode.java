package com.toyc.semantic;

/**
 * @Description 表示语义结点基类
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public abstract class AbstractRuleNode {

    /**
     * 　* @description: 生成新label
     *
     */
    public int newLabel() {
        return ++labelCount;
    }

    public void emitLable(int i) {

    }

    public void emit(String s) {

    }

    private static int labelCount = 0;
}
