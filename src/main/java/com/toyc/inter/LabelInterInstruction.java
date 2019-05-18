package com.toyc.inter;

import java.io.PrintStream;

/**
 * 表示Label输出
 */
public class LabelInterInstruction extends BaseInterInstruction {
    LabelInterInstruction(int label) {
        super(Op.NOP);
        this.label = label;
    }

    /**
     * 打印中间指令
     *
     * @param out
     */
    @Override
    public void render(PrintStream out) {
        out.println(".L" + this.label);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public int getLabel() {
        return label;
    }

    private int label;
}
