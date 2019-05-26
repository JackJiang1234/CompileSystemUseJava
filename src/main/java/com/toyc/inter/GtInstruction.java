package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示大于指令
 * */
public class GtInstruction extends GeneralInstruction{

    public GtInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.GT, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
