package com.toyc.semantic;

import com.toyc.symbol.VariableSymbol;

/**
 * 表示数组访问
 *
 * */
public class Access extends Op{
    Access(VariableSymbol arg) {
        super(arg);
    }
}
