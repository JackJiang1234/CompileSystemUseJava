package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示取负指令
 * */
public class NegInstruction extends DualArg1Result {
    public NegInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.NEG, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
