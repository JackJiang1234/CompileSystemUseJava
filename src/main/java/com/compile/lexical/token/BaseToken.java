package com.compile.lexical.token;

import java.util.Objects;

/**
 * @Description 表标token抽象基类
 * @Author jianyong.jiang
 * @Date 2019/03/19
 * @Version 1.0.0
 */
public abstract class BaseToken {
    private String name;

    public BaseToken(String name){
        Objects.requireNonNull(name);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
