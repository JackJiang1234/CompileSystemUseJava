package com.compile.lexical;

import com.compile.lexical.token.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: ParseIdentifierValveTest
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20 13:47
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

    @Override
    protected ParsePipeline createParsePipeline(Scanner scanner) {
        ParsePipeline parsePipeline = super.createParsePipeline(scanner);
        parsePipeline.addValve(new ParseIdentifierValve());

        return parsePipeline;
    }
}
