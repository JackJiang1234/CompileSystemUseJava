package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  表示二元result = op arg1
 * */
public abstract class DualArg1Result extends JustArg1ResultInterInstruction{
    public DualArg1Result(Op op, VariableSymbol result, VariableSymbol arg1) {
        super(op, result.getName(), arg1.getName());
        this.arg1 = arg1;
        this.result = result;
    }

    public VariableSymbol getResult() {
        return result;
    }

    public VariableSymbol getArg1() {
        return arg1;
    }

    private VariableSymbol result;
    private VariableSymbol arg1;
}
