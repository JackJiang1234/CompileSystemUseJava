package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

public abstract class GeneralInstruction extends Quadruple {
    public GeneralInstruction(Op op, VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(op, result.getName(), arg1.getName(), arg2.getName());
    }

    public VariableSymbol getResult() {
        return result;
    }

    public VariableSymbol getArg1() {
        return arg1;
    }

    public VariableSymbol getArg2() {
        return arg2;
    }

    private VariableSymbol result;
    private VariableSymbol arg1;
    private VariableSymbol arg2;
}
