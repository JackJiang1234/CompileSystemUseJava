package com.toyc.lexical.token;

/**
 * @ClassName: CommentToken
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/30
 * @Version 1.0.0
 */
public class CommentToken extends OperatorToken {
    public CommentToken(String literal, TagEnum tagEnum) {
        super(literal, tagEnum);
    }
}
