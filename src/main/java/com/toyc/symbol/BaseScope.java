package com.toyc.symbol;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description 表示作用域实现基类
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public abstract class BaseScope implements Scope {
    public BaseScope(Scope enclosingScope) {
        this.enclosingScope = enclosingScope;
    }

    @Override
    public Scope getEnclosingScope() {
        return this.enclosingScope;
    }

    @Override
    public void define(AbstractSymbol sym) {
        this.symbolMap.put(sym.getName(), sym);
    }

    @Override
    public AbstractSymbol resolve(String name) {
        AbstractSymbol symbol = this.symbolMap.get(name);
        if (symbol != null) {
            return symbol;
        } else if (this.enclosingScope != null) {
            return this.enclosingScope.resolve(name);
        }
        return null;
    }

    private Scope enclosingScope;
    private Map<String, AbstractSymbol> symbolMap = new LinkedHashMap<>();
}
