package com.toyc.inter;

/**
 * 表示函数入口指令
 * */
public class EntryInstruction extends JustOpInterInstruction {
    public EntryInstruction() {
        super(Op.ENTRY);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
