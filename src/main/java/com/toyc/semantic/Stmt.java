package com.toyc.semantic;

/**
 * 表示语句基类
 */
public abstract class Stmt extends AbstractRuleNode {
    /**
     * 生成中间代码
     * called with labels begin and after
     *
     * @param b 第一条指令开始label
     * @param a 下一个语句指令开始label
     */
    public void gen(int b, int a) {
    }

    public final static Stmt Null = new Stmt() {
        @Override
        public void gen(int b, int a) {
            super.gen(b, a);
        }
    };
}
