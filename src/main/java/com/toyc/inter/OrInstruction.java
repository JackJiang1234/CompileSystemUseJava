package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示逻辑或
 * */
public class OrInstruction extends GeneralInstruction{

    public OrInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.OR, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
