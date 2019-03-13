package com.compile.lexical;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author  jianyong.jiang
 * @date 2019/03/12
 * */
public class StringScannerTest extends ScannerTestBase {

    @Test
    public void testNull(){
        assertThrows(NullPointerException.class, () -> new StringScanner(null));
    }

    @Test
    public void testEmpty(){
        StringScanner scanner = new StringScanner("");
        assertFalse(scanner.hasNext());
    }

    @Test
    public void testHasContent(){
        Function<String, StringScanner> factory = content -> new StringScanner(content);
        testContent("abcd", factory);
        testContent("abcd   efg", factory);
        testContent("                  ", factory);
    }
}
