package com.toyc.symbol;

/**
 * @Description 表示作用域
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public interface Scope {
    public String getScopeName();

    public Scope getEnclosingScope();

    public void define(AbstractSymbol sym);

    public AbstractSymbol resolve(String name);
}
