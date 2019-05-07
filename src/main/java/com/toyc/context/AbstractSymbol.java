package com.toyc.context;

/**
 * @Description 表示符号基类
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public abstract class AbstractSymbol {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
