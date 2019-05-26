package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * 表示声明指令
 * */
public class DecInstruction extends BaseInterInstruction {
    public DecInstruction(VariableSymbol var) {
        super(Op.DEC);
        this.var = var;
    }

    /**
     * 打印中间指令
     *
     * @param out
     */
    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getRenderFormat(), this.var.getName()).println();
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    private VariableSymbol var;
}
