package com.toyc.inter;

import java.io.PrintStream;

/**
 * @Description 表示中间指令接口
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public interface InterInstruction {
    /**
     * 打印中间指令
     * */
    void render(PrintStream out);

    void visit(InterInstructionVisitor visitor);
}
