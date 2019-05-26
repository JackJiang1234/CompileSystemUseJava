package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  表示除法指令
 * */
public class DivInstruction extends GeneralInstruction {
    public DivInstruction(VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.DIV, result, arg1, arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
