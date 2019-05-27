package com.toyc.semantic;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示表达式id
 * */
public class Id extends Expr {
    Id(VariableSymbol id) {
        super(id);
    }
}
