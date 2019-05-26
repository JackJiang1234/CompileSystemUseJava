package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示小于指令
 * */
public class LtInstruction extends GeneralInstruction{

    public LtInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.LT, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
