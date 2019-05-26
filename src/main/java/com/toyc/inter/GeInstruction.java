package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示大于等于指令
 * */
public class GeInstruction extends GeneralInstruction{

    public GeInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.GE, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
