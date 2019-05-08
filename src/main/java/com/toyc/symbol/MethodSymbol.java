package com.toyc.symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 表示方法或函数符号
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public class MethodSymbol extends AbstractSymbol {
    public MethodSymbol(String name) {
        super(name);
    }

    public List<VariableSymbol> getArgs() {
        return Collections.unmodifiableList(this.args);
    }

    public void AddArg(VariableSymbol arg){
        this.args.add(arg);
    }

    public VariableSymbol getReturn() {
        return returnSymbol;
    }

    public void setReturn(VariableSymbol symbol) {
        this.returnSymbol = symbol;
    }

    private ArrayList<VariableSymbol> args;
    private VariableSymbol returnSymbol;
}
