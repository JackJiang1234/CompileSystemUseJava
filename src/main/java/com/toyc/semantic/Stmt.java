package com.toyc.semantic;

/**
 * 表示语句基类
 */
public abstract class Stmt extends AbstractRuleNode {
    /**
     * 生成中间代码
     * called with labels begin and after
     */
    public void gen(int b, int a) {
    }
}
