package com.toyc.lexical.token;

public class KeywordToken extends IdentifierToken {

    private KeywordEnum keywordEnum;

    public KeywordToken(KeywordEnum keywordEnum){
        super(keywordEnum.getName());
        this.keywordEnum = keywordEnum;
    }
}
