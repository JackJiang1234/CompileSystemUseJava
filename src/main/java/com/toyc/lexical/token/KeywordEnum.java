package com.toyc.lexical.token;

public enum KeywordEnum {

    BREAK("break"), CHAR("char"), ELSE("else"), CONTINUE("continue"),
    EXTERN("extern"), IF("if"), IN("in"), INT("int"), OUT("out"),
    RETURN("return"), STRING("string"), VOID("void"), WHILE("while");

    private String name;
    public String getName() {
        return this.name;
    }

    KeywordEnum(String name) {
        this.name = name;
    }
}
