package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示不等于指令
 * */
public class NeInstruction extends GeneralInstruction{

    public NeInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.NE, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
