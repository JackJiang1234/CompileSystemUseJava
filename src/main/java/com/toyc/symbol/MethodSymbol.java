package com.toyc.symbol;

import java.util.ArrayList;

/**
 * @Description 表示方法或函数符号
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public class MethodSymbol extends AbstractSymbol{
    public MethodSymbol(String name) {
        super(name);
    }

    private ArrayList<VariableSymbol> args;
    private VariableSymbol ret;
}
