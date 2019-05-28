package com.toyc.semantic;

import com.toyc.symbol.VariableSymbol;

public abstract class Logical extends Expr{
    Logical(VariableSymbol arg) {
        super(arg);
    }
}
