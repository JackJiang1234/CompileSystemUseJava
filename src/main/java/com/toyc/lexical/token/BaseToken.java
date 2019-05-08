package com.toyc.lexical.token;

/**
 * @Description 表标token抽象基类
 * @Author jianyong.jiang
 * @Date 2019/03/19
 * @Version 1.0.0
 */
public abstract class BaseToken {
    public BaseToken(Tag tag) {
        this(null, tag);
    }

    public BaseToken(String literal, Tag tag) {
        this.literal = literal;
        this.tag = tag;
    }

    public Tag getTag() {
        return this.tag;
    }

    public String getLiteral() {
        return this.literal;
    }

    public boolean notEnd() {
        return this != EndToken.END;
    }

    public boolean match(Tag tag) {
        return this.tag == tag;
    }

    public boolean isTypeToken() {
        return this.tag == Tag.CHAR || this.tag == Tag.INT || this.tag == Tag.VOID;
    }

    private String literal;
    private Tag tag;
}
