package com.toyc.symbol;

/**
 * @Description 表示局部作用域
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public class LocalScope extends BaseScope{
    public LocalScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "local";
    }
}
