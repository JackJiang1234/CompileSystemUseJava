package com.toyc.semantic;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示程序语句列表
 */
public class Seqs extends Stmt {

    public Seqs() {
        this.list = new ArrayList<>();
    }

    /**
     * 添加语句
     */
    public void add(Stmt stmt) {
        if (stmt != null && stmt != Stmt.Null) {
            this.list.add(stmt);
        }
    }

    /**
     * 生成中间代码
     * called with labels begin and after
     *
     * @param b 第一条指令开始label
     * @param a 下一个语句指令开始label
     */
    @Override
    public void gen(int b, int a) {
        if (this.list.size() == 1) {
            this.list.get(0).gen(b, a);
        } else if (this.list.size() > 1) {
            Stmt stmt;
            int before = b;
            int newLabel;
            for (int i = 0; i < this.list.size(); i++) {
                newLabel = this.newLabel();
                stmt = this.list.get(i);
                stmt.gen(before, newLabel);
                this.emitLabel(newLabel);
                before = newLabel;
            }
        }
    }

    private final List<Stmt> list;
}
