package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示逻辑非
 * */
public class NotInstruction extends DualArg1Result{
    public NotInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.NOT, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
