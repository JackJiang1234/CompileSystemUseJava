package com.compile.lexical;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author  jack
 * @date 2019/03/12
 * */
public abstract class ScannerTestBase {
    protected void testContent(String content, Function<String, ? extends Scanner> factory){
        try(Scanner scanner = factory.apply(content)){
            for(int i = 0; i < content.length(); i++){
                assertTrue(scanner.hasNext());
                assertEquals(content.charAt(i), scanner.next());
            }
        } catch (Exception e) {
            fail(e);
        }

    }

}
