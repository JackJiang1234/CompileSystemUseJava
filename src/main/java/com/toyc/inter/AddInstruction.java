package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  表示result = arg1 + age2 指令
 * */
public class AddInstruction extends GeneralInstruction {
    public AddInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.ADD, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
