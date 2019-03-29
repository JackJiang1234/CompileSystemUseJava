package com.compile.lexical;

import com.compile.lexical.token.BaseToken;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: ValveTestBase
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20 11:17
 * @Version 1.0.0
 */
public class ValveTestBase {

    protected final ParsePipeline createParsePipeline(String content) {
        return this.createParsePipeline(new StringScanner(content));
    }

    protected final ParsePipeline createParsePipeline(Scanner scanner) {
        ParsePipeline parsePipeline = new ParsePipeline(scanner);
        parsePipeline.setBasic(new EndValve());
        parsePipeline.addValve(new SkipWhiteSpaceValve());

        initPipeline(parsePipeline);

        return parsePipeline;
    }

    protected BaseToken parse(String content) {
        ParsePipeline parsePipeline = this.createParsePipeline(new StringScanner(content));
        return parsePipeline.invokeParse();
    }

    protected void initPipeline(ParsePipeline pipeline) {

    }

    protected void assertAsExpectedToken(BaseToken expected, BaseToken target) {
        assertEquals(expected.getClass(), target.getClass());
        assertEquals(expected.getLiteral(), target.getLiteral());
    }
}
