package com.toyc.lexical;

import com.toyc.lexical.token.BaseToken;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * */
public interface Lexer extends AutoCloseable {
    int getLine();
    int getCol();
    BaseToken next();
}
