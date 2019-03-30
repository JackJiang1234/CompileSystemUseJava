package com.compile.lexical;

import com.compile.lexical.token.BaseToken;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * */
public interface Lexer extends AutoCloseable {
    BaseToken next();

    static Lexer create(String fileName) throws FileNotFoundException {
        return new LexerImpl(fileName);
    }

    static Lexer create(InputStream stream) {
        return new LexerImpl(stream);
    }
}
