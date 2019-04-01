package com.toyc.lexical.token;

/**
 * 单个字符
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class CharToken extends BaseToken {
    public CharToken(char name){
        super(Character.toString(name));
        this.value = name;
    }

    public char getValue(){
        return this.value;
    }

    private char value;
}
