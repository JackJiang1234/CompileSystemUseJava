package com.toyc.lexical.token;

public class KeywordToken extends IdentifierToken {

    public KeywordEnum getKeywordEnum(){
        return this.keywordEnum;
    }

    public boolean match(KeywordEnum keywordEnum){
        return this.keywordEnum.equals(keywordEnum);
    }

    public KeywordToken(KeywordEnum keywordEnum){
        super(keywordEnum.getName());
        this.keywordEnum = keywordEnum;
    }

    private KeywordEnum keywordEnum;
}
