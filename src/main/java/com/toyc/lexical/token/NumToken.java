package com.toyc.lexical.token;

public class NumToken extends BaseToken {

    private int value;

    public NumToken(String name, int value) {
        super(name, Tag.NUMBER);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
