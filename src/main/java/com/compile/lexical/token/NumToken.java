package com.compile.lexical.token;

public class NumToken extends BaseToken {

    private int value;

    public NumToken(String name, int value) {
        super(name);
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
