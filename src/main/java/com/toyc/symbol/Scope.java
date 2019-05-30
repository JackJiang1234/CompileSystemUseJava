package com.toyc.symbol;

/**
 * @Description 表示作用域
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public interface Scope {
    String getScopeName();

    Scope getEnclosingScope();

    void define(AbstractSymbol sym);

    AbstractSymbol resolve(String name);
}
