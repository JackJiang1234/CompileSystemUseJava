package com.toyc.inter;

/**
 * 表示函数退出
 * */
public class ExitInstruction extends JustOpInterInstruction{
    public ExitInstruction() {
        super(Op.EXIT);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
