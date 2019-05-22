package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * @Description 仅使用arg1中间指令
 * @Author jianyong.jiang
 * @Date 2019/5/22
 * @Version 1.0.0
 */
public class JustArg1InterInstruction extends BaseInterInstruction{
    public JustArg1InterInstruction(Op op, VariableSymbol arg1) {
        super(op);
    }

    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getInstructionFormat(), this.arg1).println();
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public VariableSymbol getArg1() {
        return arg1;
    }

    private VariableSymbol arg1;
}
