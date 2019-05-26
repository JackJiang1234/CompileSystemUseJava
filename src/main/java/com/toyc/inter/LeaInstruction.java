package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  表示取址
 * */
public class LeaInstruction extends DualArg1Result{
    public LeaInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.LEA, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
