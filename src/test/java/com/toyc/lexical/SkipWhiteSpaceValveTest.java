package com.toyc.lexical;

import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.EndToken;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @ClassName: SkipWhiteSpaceValveTest
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public class SkipWhiteSpaceValveTest extends ValveTestBase {

    @Test
    public void testEmptyStringParse(){
        ParsePipeline parsePipeline = this.createParsePipeline(new StringScanner(""));
        BaseToken token = parsePipeline.invokeParse();
        assertEquals(EndToken.END, token);
    }

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
