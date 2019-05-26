package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  不等跳转
 * */
public class JneInstruction extends Quadruple{
    public JneInstruction(int jmpLabel, VariableSymbol arg1, VariableSymbol arg2) {
        super(Op.JNE, Integer.toString(jmpLabel), arg1.getName(), arg2.getName());
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
