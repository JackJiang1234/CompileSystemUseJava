package com.toyc.lexical;

import com.toyc.lexical.token.EndToken;
import com.toyc.lexical.token.SeparatorToken;
import com.toyc.lexical.token.SeparatorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseSeparatorValveTest extends ValveTestBase {

    @Test
    public void testEffectiveSeparatorParse() {
        for (char c : SeparatorUtil.getSeparators()){
            ParsePipeline pipeline = this.createParsePipeline(Character.toString(c));
            SeparatorToken token = (SeparatorToken) pipeline.invokeParse();
            assertEquals(c, token.getValue());

            Assertions.assertEquals(EndToken.END, pipeline.invokeParse());
        }
    }

    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParseSeparatorValve());
    }
}