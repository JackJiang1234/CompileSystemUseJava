package com.toyc.semantic;

import com.toyc.inter.Instruction;

/**
 * @Description 表示语义结点基类
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public abstract class AbstractRuleNode {

    /**
     *  生成新label
     *
     */
    public int newLabel() {
        return ++labelCount;
    }

    /**
     * 输出指令
     * */
    protected final void emit(Instruction instruction) {

    }

    private static int labelCount = 0;
}
