package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * @ClassName: JustArg1Arg2InterInstruction
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/5/22
 * @Version 1.0.0
 */
public abstract class JustArg1Arg2InterInstruction extends BaseInterInstruction{
    public JustArg1Arg2InterInstruction(Op op, String arg1, String arg2) {
        super(op);
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getRenderFormat(), this.arg1, this.arg2).println();
    }

    private String arg1;
    private String arg2;
}
