package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

public class ModInstruction extends GeneralInstruction {
    public ModInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.MOD, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
