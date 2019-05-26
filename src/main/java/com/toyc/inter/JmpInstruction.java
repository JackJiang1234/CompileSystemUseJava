package com.toyc.inter;

/**
 * 无条件跳转指令
 */
public class JmpInstruction extends LabelInstruction {
    public JmpInstruction(int label) {
        super(Op.JMP, label);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
