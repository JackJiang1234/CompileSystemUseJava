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
public class JustArg1Arg2InterInstruction extends BaseInterInstruction{
    public JustArg1Arg2InterInstruction(Op op, VariableSymbol arg1, VariableSymbol arg2) {
        super(op);
    }

    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getInstructionFormat(), this.arg1.getName(), this.arg2.getName()).println();
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public VariableSymbol getArg1() {
        return arg1;
    }

    public VariableSymbol getArg2() {
        return arg2;
    }

    private VariableSymbol arg1;
    private VariableSymbol arg2;
}
