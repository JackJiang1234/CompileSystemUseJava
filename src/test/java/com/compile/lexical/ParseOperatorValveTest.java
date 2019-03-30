package com.compile.lexical;

import com.compile.lexical.token.CommentToken;
import com.compile.lexical.token.EndToken;
import com.compile.lexical.token.OperatorToken;
import com.compile.lexical.token.OperatorUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    }

    @Test
    public void testUnknownCharParse() {

    }


    @Test
    public void testMixedParse() {

    }


    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParseOperatorValve());
    }
}