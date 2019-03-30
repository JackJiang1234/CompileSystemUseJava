package com.compile.lexical;

import com.compile.lexical.token.EndToken;
import com.compile.lexical.token.SeparatorToken;
import com.compile.lexical.token.SeparatorUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseSeparatorValveTest extends ValveTestBase {

    @Test
    public void testEffectiveSeparatorParse() {
        for (char c : SeparatorUtil.getSeparators()){
            ParsePipeline pipeline = this.createParsePipeline(Character.toString(c));
            SeparatorToken token = (SeparatorToken) pipeline.invokeParse();
            assertEquals(c, token.getValue());

            assertEquals(EndToken.END, pipeline.invokeParse());
        }
    }

    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParseSeparatorValve());
    }
}