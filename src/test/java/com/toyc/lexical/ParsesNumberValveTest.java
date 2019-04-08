package com.toyc.lexical;

import com.toyc.lexical.token.OperatorToken;
import org.junit.jupiter.api.Assertions;
import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.EndToken;
import com.toyc.lexical.token.NumToken;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @ClassName: 解析数字token测试
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/21
 * @Version 1.0.0
 */
public class ParsesNumberValveTest extends ValveTestBase {

    @Test
    public void testParseNormalDecimalShouldPassed() {
        testParseNormalNumber(ParseNumUtil.DECIMAL_NUMBER_MAP, "");
    }

    @Test
    public void testParseNormalOctalShouldPassed() {
        testParseNormalNumber(ParseNumUtil.OCT_NUMBER_MAP, "0");
    }

    @Test
    public void testParseNormalHexShouldPassed() {
        testParseNormalNumber(ParseNumUtil.HEX_NUMBER_MAP, "0x");
    }

    @Test
    public void testParseNumSequenceShouldPassed() {
        ParsePipeline pipeline = this.createParsePipeline("1 01 0x1");

        BaseToken token = pipeline.invokeParse();
        assertNumberToken(new NumToken("1", 1), (NumToken) token);

        token = pipeline.invokeParse();
        assertNumberToken(new NumToken("01", 1), (NumToken) token);

        token = pipeline.invokeParse();
        assertNumberToken(new NumToken("0x1", 1), (NumToken) token);
    }

    @Test
    public void testParseJustHexPrefixShouldThrowException() {
        assertThrows(LexicalParseException.class, () -> testAsExpected("0x", 0));
    }

    @Test
    public void testParseErrorFormatOctalShouldThrowException() {
        assertThrows(LexicalParseException.class, () -> testAsExpected("08", 0));
    }

    @Test
    public void testParseNumFaultToleranceShouldPassed() {
        testParseNumFaultTolerance("111xxx", 111);
        testParseNumFaultTolerance("07xxx", 7);
        testParseNumFaultTolerance("0x6xxx", 6);
    }

    @Test
    public void testMixedParse(){
        ParsePipeline pipeline = this.createParsePipeline("10;");
        pipeline.addValve(new ParseOperatorValve());
        NumToken token = (NumToken)pipeline.invokeParse();
        assertEquals("10", token.getLiteral());
        assertEquals(10, token.getValue());

        OperatorToken separatorToken = (OperatorToken)pipeline.invokeParse();
        assertEquals(";", separatorToken.getLiteral());
    }

    private void testParseNumFaultTolerance(String numStr, int expectedValue) {
        BaseToken token = this.parse(numStr);
        assertEquals(expectedValue, ((NumToken) token).getValue());
    }

    private void testParseNormalNumber(Map<Character, Integer> map, String prefix) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            String numStr = prefix + entry.getKey();
            testAsExpected(numStr, entry.getValue().intValue());
        }
    }

    private void testAsExpected(String expectedNumStr, int expectedNum) {
        ParsePipeline pipeline = this.createParsePipeline(expectedNumStr);
        BaseToken token = pipeline.invokeParse();
        this.assertNumberToken(new NumToken(expectedNumStr, expectedNum), ((NumToken) token));
        Assertions.assertEquals(EndToken.END, pipeline.invokeParse());
    }

    private void assertNumberToken(NumToken expected, NumToken target) {
        this.assertAsExpectedToken(expected, target);
        assertEquals(expected.getValue(), target.getValue());
    }

    @Override
    protected void initPipeline(ParsePipeline pipeline) {
        pipeline.addValve(new ParsesNumberValve());
    }
}
