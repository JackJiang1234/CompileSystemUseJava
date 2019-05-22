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

    }

    @Override
    public void visit(InterInstructionVisitor visitor) {

    }
}
