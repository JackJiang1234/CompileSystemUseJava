package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * 表示堆栈指令
 * */
public class StackInterInstruction extends BaseInterInstruction {
    public StackInterInstruction(Op op, VariableSymbol arg) {
        super(op);
    }

    /**
     * 打印中间指令
     *
     * @param out
     */
    @Override
    public void render(PrintStream out) {

    }

    @Override
    public void visit(InterInstructionVisitor visitor) {

    }
}
