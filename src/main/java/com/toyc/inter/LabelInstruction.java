package com.toyc.inter;

import java.io.PrintStream;

/**
 * 表示Label输出
 */
public class LabelInstruction extends JustArg1InterInstruction {
    public LabelInstruction(int label) {
        super(Op.LABEL, Integer.toString(label));
        this.label = label;
    }

    LabelInstruction(Op op, int label) {
        super(op, Integer.toString(label));
        this.label = label;
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
