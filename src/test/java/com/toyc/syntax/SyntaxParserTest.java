package com.toyc.syntax;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyc.lexical.LexerFactory;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.jupiter.api.Assertions.*;

class SyntaxParserTest {

    @Test
    void testParseEmptyProgram() {
        SyntaxParser parser = this.createParse("");
        ProgramNode node = parser.parse();
        assertNotNull(node);
        assertTrue(node.getSegments().isEmpty());
        System.out.println(toJson(node));
    }

    @Test
    void testParseVarDef() throws JSONException {
        assertSyntaxParseTest("ParseVarDefExpected.json", "int i;");
    }

    @Test
    void testParseVarDefList() throws JSONException {
        assertSyntaxParseTest("ParseVarDefListExpected.json", "int i; int b;");
    }

    private void assertSyntaxParseTest(String expectedFileName, String content) {
        SyntaxParser parser = this.createParse(content);
        ProgramNode programNode = parser.parse();
        try {
            JSONAssert.assertEquals(this.getFileContent(expectedFileName), this.toJson(programNode), false);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFileContent(String name) {
        try {
            return IOUtils.resourceToString("syntax/" + name, Charset.forName("UTF-8"), this.getClass().getClassLoader());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.SETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.IS_GETTER, JsonAutoDetect.Visibility.NONE);
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private SyntaxParser createParse(String parseContent) {
        return SyntaxParserFactory.create(LexerFactory.createForContent(parseContent));
    }
}