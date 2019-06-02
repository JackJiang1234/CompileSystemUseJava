package com.toyc.semantic;

/**
 * @Description 表示两个语句序列
 * @Author jianyong.jiang
 * @Date 2019/5/9
 * @Version 1.0.0
 */
public class Seq extends Stmt {
    public Seq(Stmt stmt1, Stmt stmt2) {
        this.stmt1 = stmt1;
        this.stmt2 = stmt2;
    }

    /**
     * 生成中间代码
     * called with labels begin and after
     *
     * @param b  第一条指令开始label
     * @param a  下一个语句指令开始label
     */
    @Override
    public void gen(int b, int a) {
        if (stmt1 == Stmt.Null) {
            stmt2.gen(b, a);
        } else if (stmt2 == Stmt.Null) {
            stmt1.gen(b, a);
        } else {
            int label = this.newLabel();
            stmt1.gen(b, label);
            emitLabel(label);
            stmt2.gen(label, a);
        }
    }

    private Stmt stmt1;
    private Stmt stmt2;
}
