package com.toyc.lexical.token;

public class IdentifierToken extends BaseToken {
    public IdentifierToken(String name){
        super(name, Tag.ID);
    }
}
