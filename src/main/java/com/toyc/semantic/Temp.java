package com.toyc.semantic;

import com.toyc.symbol.Type;
import com.toyc.symbol.VariableSymbol;

/**
 * 表示生成一个临时变量
 * */
public class Temp extends Expr {
    public Temp(Type t) {
        super(new VariableSymbol("t" + count , t));
        count++;
    }

    static int count = 0;
}
