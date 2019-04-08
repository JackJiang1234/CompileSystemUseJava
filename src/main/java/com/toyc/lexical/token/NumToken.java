package com.toyc.lexical.token;

public class NumToken extends BaseToken {

    private int value;

    public NumToken(String name, int value) {
        super(name, TagEnum.NUMBER);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
