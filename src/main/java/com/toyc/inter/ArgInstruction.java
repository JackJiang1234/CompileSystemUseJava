package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示参数传递
 */
public class ArgInstruction extends JustArg1InterInstruction {
    public ArgInstruction(VariableSymbol arg) {
        super(Op.ARG, arg.getName());
        this.arg = arg;
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public VariableSymbol getArg() {
        return arg;
    }

    private VariableSymbol arg;
}
