package com.toyc.inter;

import com.toyc.symbol.MethodSymbol;
import com.toyc.symbol.VariableSymbol;

/**
 *  有结果值返回
 * */
public class RetvInstruction extends JustArg1Arg2InterInstruction {
    public RetvInstruction(VariableSymbol result, MethodSymbol method) {
        super(Op.RETV, result.getName(), method.getName());
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
