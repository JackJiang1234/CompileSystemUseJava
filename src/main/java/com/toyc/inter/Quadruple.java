package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 *  表示四元式指令 result = arg1 op arg2
 */
public abstract class Quadruple extends BaseInterInstruction {
    public Quadruple(Op op, String result, String arg1, String arg2) {
        super(op);
        this.result = result;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    /**
     * 打印中间指令
     *
     * @param out
     */
    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getRenderFormat(), this.result, this.arg1, this.arg2).println();
    }

    private String result;
    private String arg1;
    private String arg2;
}
