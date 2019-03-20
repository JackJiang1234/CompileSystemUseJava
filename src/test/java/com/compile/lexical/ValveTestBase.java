package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.KeywordToken;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @ClassName: ValveTestBase
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20 11:17
 * @Version 1.0.0
 */
public class ValveTestBase {

    protected ParsePipeline createParsePipeline(Scanner scanner) {
        ParsePipeline parsePipeline = new ParsePipeline(scanner);
        parsePipeline.setBasic(new EndValve());
        parsePipeline.addValve(new SkipWhiteSpaceValve());

        return parsePipeline;
    }

    protected void assertAsExpectedToken(BaseToken expected, BaseToken target){
        assertEquals(expected.getClass(), target.getClass());
        assertEquals(expected.getName(), target.getName());
    }
}
