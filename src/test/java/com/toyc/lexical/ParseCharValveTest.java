package com.toyc.lexical;

import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.CharToken;
import com.toyc.lexical.token.EndToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @ClassName: ParseCharValveTest
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/29
 * @Version 1.0.0
 */
public class ParseCharValveTest extends ValveTestBase {
    @Test
    public void testParseEscapeChar() {
        for (int i = 0; i < escapeCharStringWrappers.length; i++) {
            testAsExpected(escapeChars[i], escapeCharStringWrappers[i]);
        }
    }

    @Test
    public void testUnknownEscapeChar(){
        ParsePipeline pipeline = this.createParsePipeline("'\\b'");
        assertThrows(LexicalParseException.class,() -> pipeline.invokeParse());
    }

    @Test
    public void testErrorFormatChar(){
        ParsePipeline pipeline = this.createParsePipeline("'ab'");
        assertThrows(LexicalParseException.class,() -> pipeline.invokeParse());
    }

    @Test
    public void testNormalCharParse() {
        testInRange('a', 'z');
        testInRange('A', 'Z');
        testInRange('0', '9');
    }

    @Test
    public void testMixedParse() {
        ParsePipeline pipeline = this.createParsePipeline("'a' '\t' 'b'");
        CharToken token = (CharToken) pipeline.invokeParse();
        assertEquals('a', token.getValue());

        token = (CharToken) pipeline.invokeParse();
        assertEquals('\t', token.getValue());

        token = (CharToken) pipeline.invokeParse();
        assertEquals('b', token.getValue());

        BaseToken endToken = pipeline.invokeParse();
        this.assertAsExpectedToken(EndToken.END, endToken);
    }

    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParseCharValve());
    }

    private void testInRange(int from, int to) {
        for (int i = from, end = to + 1; i < end; i++) {
            testAsExpected((char) i, String.format("'%c'", i));
        }
    }

    private void testAsExpected(char expectedChar, String test) {
        ParsePipeline pipeline = this.createParsePipeline(test);
        CharToken token = (CharToken) pipeline.invokeParse();
        assertEquals(expectedChar, token.getValue());
        BaseToken endToken = pipeline.invokeParse();
        this.assertAsExpectedToken(EndToken.END, endToken);
    }

    private char[] escapeChars = new char[]{
            '\t', '\0', '\\', '\n', '\''
    };

    private String[] escapeCharStringWrappers = new String[]{
            "'\\t'", "'\\0'", "'\\\\'", "'\\n'", "'\\''"
    };

}
