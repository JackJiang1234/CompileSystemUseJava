package com.toyc.inter;

/**
 * 表示Nop指令
 * */
public class NopInstruction extends JustOpInterInstruction {
    public NopInstruction() {
        super(Op.NOP);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
