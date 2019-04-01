package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.*;

class LexerTest {

    @Test
    void testGetToken() throws Exception {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Lexer lexer = Lexer.create(classLoader.getResourceAsStream("lexical/test.c"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("lexical/test_expect.txt")));
        BaseToken token;
        String line;

        while ((token = lexer.next()).notEnd()){
            line = reader.readLine();
            assertEquals(line, token.getLiteral());
        }

        lexer.close();
        reader.close();
    }
}