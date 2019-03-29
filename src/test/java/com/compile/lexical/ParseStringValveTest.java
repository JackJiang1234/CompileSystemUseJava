package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.EndToken;
import com.compile.lexical.token.StringToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseStringValveTest extends ValveTestBase{

    @Test
    public void testEmptyStringParse(){
        this.test("", "");
    }

    @Test
    public void testNormalStringParse(){
        String str = "abc";
        this.test(str, String.format("\"%s\"", str));
    }

    @Test
    public void testIncludeEscapeChar(){
        String str = "abc\\t";
        this.test("abc\t", String.format("\"%s\"", str));
        System.out.println(str);

        str = "abc\\t\\n";
        this.test("abc\t\n", String.format("\"%s\"", str));
        System.out.println(str);

        str = "\\tabc";
        this.test("\tabc", String.format("\"%s\"", str));
        System.out.println(str);

        str = "\\t\\n";
        this.test("\t\n", String.format("\"%s\"", str));
        System.out.println(str);
    }

    @Test
    public void testMutiStringParse(){
        String str1 = "abc";
        String str2 = "efg";
        ParsePipeline pipeline = this.createParsePipeline(String.format("\"%s\" \"%s\" ", str1, str2));
        StringToken token = (StringToken) pipeline.invokeParse();
        assertEquals(str1, token.getLiteral());

        token = (StringToken) pipeline.invokeParse();
        assertEquals(str2, token.getLiteral());

        BaseToken end = pipeline.invokeParse();
        this.assertAsExpectedToken(EndToken.END, end);
    }

    private void test(String expected, String quoteString){
        ParsePipeline pipeline = this.createParsePipeline(quoteString);
        StringToken token = (StringToken) pipeline.invokeParse();
        assertEquals(expected, token.getLiteral());

        BaseToken end = pipeline.invokeParse();
        this.assertAsExpectedToken(EndToken.END, end);
    }

    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParseStringValve());
    }

}