package com.toyc.lexical.token;

public enum KeywordEnum {
    CHAR("char", true), VOID("void", true), INT("int", true),
    BREAK("break", false), ELSE("else", false), CONTINUE("continue", false),
    EXTERN("extern", false), IF("if", false), IN("in", false), OUT("out", false),
    RETURN("return", false), STRING("string", false), WHILE("while", false);

    public boolean isType() {
        return this.isType;
    }

    public String getName() {
        return this.name;
    }

    KeywordEnum(String name, boolean isType) {
        this.name = name;
        this.isType = isType;
    }

    private String name;
    private boolean isType;
}
