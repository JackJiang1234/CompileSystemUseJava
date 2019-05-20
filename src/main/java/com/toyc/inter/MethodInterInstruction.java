package com.toyc.inter;

import com.toyc.semantic.Method;
import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * 表示方法相关指令，如call
 * */
public class MethodInterInstruction extends BaseInterInstruction {
    public MethodInterInstruction(Op op, Method m, VariableSymbol rs) {
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
