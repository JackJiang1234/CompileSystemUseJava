package com.toyc.syntax;

import com.toyc.lexical.Lexer;

/**
 * @ClassName: SyntaxParserFactory
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/8
 * @Version 1.0.0
 */
public final class SyntaxParserFactory {
    public static SyntaxParser create(Lexer lexer){
        return new SyntaxParserImpl(lexer);
    }
}
