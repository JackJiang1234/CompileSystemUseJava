package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示逻辑短路与
 * */
public class AndInstruction extends GeneralInstruction{

    public AndInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.AND, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
