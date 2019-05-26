package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  为真跳转
 * */
public class JtInstruction extends DualArg1Result{
    public JtInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.JT, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
