package com.toyc.lexical;

import com.toyc.lexical.token.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @ClassName: ParseIdentifierValveTest
 * @Description 解析id 或 keyword 测试
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public class ParseIdentifierValveTest extends ValveTestBase {

    @Test
    public void testKeywordIdentifierParse() {
        ParsePipeline pipeline = this.createParsePipeline(new StringScanner("int i"));

        this.assertAsExpectedToken(new KeywordToken(KeywordUtils.getKeywordEnumByName("int")), pipeline.invokeParse());
        this.assertAsExpectedToken(new IdentifierToken("i"), pipeline.invokeParse());

        assertEquals(EndToken.END, pipeline.invokeParse());
    }

    @Test
    public void testAllKeywordsParse() {
        for (KeywordEnum key : KeywordEnum.values()) {
            ParsePipeline pipeline = this.createParsePipeline(new StringScanner(key.getName()));
            this.assertAsExpectedToken(new KeywordToken(key), pipeline.invokeParse());
            assertEquals(EndToken.END, pipeline.invokeParse());
        }
    }

    @Test
    public void testMixedParse(){
        ParsePipeline pipeline = this.createParsePipeline("fun()");
        this.assertAsExpectedToken(new IdentifierToken("fun"), pipeline.invokeParse());
    }

    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParseIdentifierValve());
    }
}
