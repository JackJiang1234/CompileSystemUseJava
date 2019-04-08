package com.toyc.lexical.token;

import java.util.Objects;

/**
 * @Description 表标token抽象基类
 * @Author jianyong.jiang
 * @Date 2019/03/19
 * @Version 1.0.0
 */
public abstract class BaseToken {
    public BaseToken(TagEnum tagEnum) {
        this(null, tagEnum);
    }

    public BaseToken(String literal, TagEnum tagEnum) {
        this.literal = literal;
        this.tag = tagEnum;
    }

    public TagEnum getTag() {
        return this.tag;
    }

    public String getLiteral() {
        return this.literal;
    }

    public boolean notEnd() {
        return this != EndToken.END;
    }

    public boolean match(TagEnum tag) {
        return this.tag == tag;
    }

    private String literal;
    private TagEnum tag;
}
