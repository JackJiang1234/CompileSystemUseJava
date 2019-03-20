package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.EndToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @ClassName: SkipWhiteSpaceValveTest
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20 11:09
 * @Version 1.0.0
 */
public class SkipWhiteSpaceValveTest extends ValveTestBase {

    @Test
    public void testSkipWhiteSpaceNoContent() {
        ParsePipeline parsePipeline = this.createParsePipeline(new StringScanner("  \t   \r\n   "));
        BaseToken token = parsePipeline.invokeParse();
        assertEquals(EndToken.END, token);
    }

    @Test
    public void testSkipWhiteSpaceHasContent() {
        ParsePipeline parsePipeline = this.createParsePipeline(new StringScanner("    abc"));
        Throwable exception = assertThrows(LexicalParseException.class, () -> parsePipeline.invokeParse());
        assertEquals(String.format(EndValve.EXCEPTON_MESSAGE, "abc"), exception.getMessage());
    }


}