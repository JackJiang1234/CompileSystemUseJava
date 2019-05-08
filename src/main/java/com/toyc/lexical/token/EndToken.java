package com.toyc.lexical.token;

/**
 * @ClassName: EndToken
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public class EndToken extends BaseToken {

    public final static EndToken END = new EndToken();

    private EndToken(){
        super("END_OF_FILE", Tag.END);
    }
}
