package com.toyc.lexical.token;

/**
 * 字符串
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class StringToken extends BaseToken {
    public StringToken(String literal){
        super(literal, TagEnum.STRING);
    }
}
