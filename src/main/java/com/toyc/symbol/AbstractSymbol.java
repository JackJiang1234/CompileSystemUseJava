package com.toyc.symbol;

/**
 * @Description 表示符号基类
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public abstract class AbstractSymbol {
    public AbstractSymbol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;
}
