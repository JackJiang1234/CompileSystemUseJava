package com.toyc.syntax;

import com.toyc.lexical.Lexer;
import com.toyc.lexical.LexerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SyntaxParserTest {

    @Test
    void testParseEmptyProgram() {
        SyntaxParser parser = this.createParse("");
        ProgramNode node = parser.parse();
        assertNotNull(node);
        assertTrue(node.getSegments().isEmpty());
    }

    private SyntaxParser createParse(String parseContent) {
        return SyntaxParserFactory.create(LexerFactory.createForContent(parseContent));
    }
}