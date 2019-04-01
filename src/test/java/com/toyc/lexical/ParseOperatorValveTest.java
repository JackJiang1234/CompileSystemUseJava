package com.toyc.lexical;

import com.toyc.lexical.token.CommentToken;
import com.toyc.lexical.token.EndToken;
import com.toyc.lexical.token.OperatorToken;
import com.toyc.lexical.token.OperatorUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParseOperatorValveTest extends ValveTestBase {

    @Test
    public void testUnaryOperatorParse() {
        OperatorUtil.getUnaryOperatorSet().forEach(c -> {
            ParsePipeline pipeline = this.createParsePipeline(c.toString());
            OperatorToken token = (OperatorToken) pipeline.invokeParse();

            assertEquals(c.toString(), token.getLiteral());
            this.assertAsExpectedToken(EndToken.END, pipeline.invokeParse());
        });
    }

    @Test
    public void testBinaryOperatorParse() {
        OperatorUtil.getBinaryOperatorSet().forEach(op -> {
            ParsePipeline pipeline = this.createParsePipeline(op);
            OperatorToken token = (OperatorToken) pipeline.invokeParse();

            assertEquals(op, token.getLiteral());
            this.assertAsExpectedToken(EndToken.END, pipeline.invokeParse());
        });
    }

    @Test
    public void testCommentParse() {
        String singleCommentLine = "//abc";
        ParsePipeline pipeline = this.createParsePipeline(singleCommentLine);
        CommentToken token = (CommentToken) pipeline.invokeParse();
        assertEquals(singleCommentLine, token.getLiteral());

        String multiCommentLine = "/*abc */";
        pipeline = this.createParsePipeline(multiCommentLine);
        token = (CommentToken) pipeline.invokeParse();
        assertEquals(multiCommentLine, token.getLiteral());
    }

    @Test
    public void testErrorEndCommentParse() {
        String multiCommentLine = "/*abc *&";
        ParsePipeline pipeline = this.createParsePipeline(multiCommentLine);
        assertThrows(LexicalParseException.class, () -> pipeline.invokeParse());
    }


    @Test
    public void testMixedParse() {
        ParsePipeline pipeline = this.createParsePipeline("* /*abc */ -");
        OperatorToken token = (OperatorToken) pipeline.invokeParse();
        assertEquals("*", token.getLiteral());

        token = (OperatorToken) pipeline.invokeParse();
        assertEquals("/*abc */", token.getLiteral());

        token = (OperatorToken) pipeline.invokeParse();
        assertEquals("-", token.getLiteral());

        this.assertAsExpectedToken(EndToken.END, pipeline.invokeParse());
    }


    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParseOperatorValve());
    }
}