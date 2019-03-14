package com.compile.lexical;

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
            while (scanner.hasNext()) {
                assertEquals(content.charAt(i), scanner.next());

                scanner.pushBack(content.charAt(i));
                assertEquals(content.charAt(i), scanner.next());

                i++;
            }
            assertEquals(content.length(), i);
        } catch (Exception e) {
            fail(e);
        }

    }

}
