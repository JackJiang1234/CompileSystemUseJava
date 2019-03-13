package com.compile.lexical;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author  jianyong.jiang
 * @date 2019/03/12
 * */
public abstract class ScannerTestBase {
    protected void testContent(String content, Function<String, ? extends Scanner> factory){

        try(Scanner scanner = factory.apply(content)){
            char src;
            for(int i = 0; i < content.length(); i++){
                assertTrue(scanner.hasNext());
                src = content.charAt(i);
                assertEquals(src, scanner.next());

                scanner.pushBack(src);
                assertEquals(src, scanner.next());
            }
        } catch (Exception e) {
            fail(e);
        }

    }

}
