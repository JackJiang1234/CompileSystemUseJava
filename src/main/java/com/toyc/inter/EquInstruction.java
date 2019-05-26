package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示等于指令
 * */
public class EquInstruction extends GeneralInstruction{

    public EquInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.EQU, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
