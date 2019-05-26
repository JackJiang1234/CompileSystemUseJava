package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * @ClassName: JustArg1ResultInterInstruction
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/5/22
 * @Version 1.0.0
 */
public abstract class JustArg1ResultInterInstruction extends BaseInterInstruction {
    public JustArg1ResultInterInstruction(Op op, String result, String arg1) {
        super(op);
        this.arg1 = arg1;
        this.result = result;
    }

    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getRenderFormat(), this.result, this.arg1).println();
    }

    private String result;
    private String arg1;
}
