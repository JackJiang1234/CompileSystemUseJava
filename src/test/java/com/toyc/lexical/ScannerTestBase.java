package com.toyc.lexical;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author jianyong.jiang
 * @date 2019/03/12
 */
public abstract class ScannerTestBase {
    protected void testContent(String content, Function<String, ? extends Scanner> factory) {

        try (Scanner scanner = factory.apply(content)) {
            int i = 0;
            int readChar;
            int oldChar;
            while ((readChar = scanner.next()) != BaseScanner.EOF) {
                assertEquals(content.charAt(i), readChar);

                oldChar = readChar;
                scanner.pushBack(readChar);
                readChar = scanner.next();
                assertEquals(oldChar, readChar);

                i++;
            }
            assertEquals(content.length(), i);
        } catch (Exception e) {
            fail(e);
        }

    }

}
