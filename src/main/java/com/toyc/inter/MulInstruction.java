package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示乘法指令
 * */
public class MulInstruction extends GeneralInstruction {
    public MulInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.MUL, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
