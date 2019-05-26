package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

public class SubInstruction extends GeneralInstruction {
    public SubInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.SUB, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
