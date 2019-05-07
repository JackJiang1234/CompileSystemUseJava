package com.toyc.symbol;

/**
 * @Description 表示全局作用域
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public class GlobalScope extends BaseScope {

    public GlobalScope() {
        super(null);
    }

    @Override
    public String getScopeName() {
        return "global";
    }
}
