package com.toyc.lexical;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @ClassName: LexerFactory
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/8
 * @Version 1.0.0
 */
public final class LexerFactory {

    public static Lexer createForFile(String fileName) throws FileNotFoundException {
        return new LexerImpl(new SourceFileScanner(fileName));
    }

    public static Lexer createForSteam(InputStream stream) {
        return new LexerImpl(new SourceFileScanner(stream));
    }

    public static Lexer createForContent(String content) {
        return new LexerImpl(new StringScanner(content));
    }
}
