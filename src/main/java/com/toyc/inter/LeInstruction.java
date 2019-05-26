package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示小于等于指令
 * */
public class LeInstruction extends GeneralInstruction{

    public LeInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.LE, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
