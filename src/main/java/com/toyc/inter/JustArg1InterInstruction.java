package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * @Description 仅使用arg1中间指令
 * @Author jianyong.jiang
 * @Date 2019/5/22
 * @Version 1.0.0
 */
public abstract class JustArg1InterInstruction extends BaseInterInstruction{
    public JustArg1InterInstruction(Op op, String arg1) {
        super(op);
        this.arg1 = arg1;
    }

    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getRenderFormat(), this.arg1).println();
    }

    private String arg1;
}
