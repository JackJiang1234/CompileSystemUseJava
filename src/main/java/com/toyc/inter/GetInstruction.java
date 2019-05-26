package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  获取右值 result = *arg1
 * */
public class GetInstruction extends DualArg1Result{
    public GetInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.GET, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
