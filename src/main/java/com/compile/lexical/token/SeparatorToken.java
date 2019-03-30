package com.compile.lexical.token;

public class SeparatorToken extends BaseToken {
    public SeparatorToken(char literal){
        super(Character.toString(literal));
        this.value = literal;
    }

    public char getValue(){
        return this.value;
    }

    private char value;
}
