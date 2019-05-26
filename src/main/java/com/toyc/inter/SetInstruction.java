package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  设置左值 *arg1 = result
 * */
public class SetInstruction extends DualArg1Result{
    public SetInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.SET, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
