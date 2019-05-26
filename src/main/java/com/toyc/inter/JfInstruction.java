package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  为假跳转
 * */
public class JfInstruction extends DualArg1Result{
    public JfInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.JF, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
