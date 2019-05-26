package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  表示赋值指令
 * */
public class AssignInstruction extends DualArg1Result{
    public AssignInstruction(VariableSymbol result, VariableSymbol arg1) {
        super(Op.ASSIGN, result, arg1);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
