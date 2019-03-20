package com.compile.lexical;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jianyong.jiang
 * @date 2019/03/16
 */
public class ParsePipelineTest {

    @Test
    public void testNotSetBasicValve() {
        ParsePipeline parsePipeline = new ParsePipeline(null);
        assertThrows(LexicalParseException.class, () -> parsePipeline.invokeParse());
    }

    @Test
    public void testSetBasicValve() {
        ParsePipeline parsePipeline = new ParsePipeline(null);
        final boolean[] isRun = {false};
        parsePipeline.setBasic(createValve(c -> isRun[0] = true));
        parsePipeline.invokeParse();
        assertTrue(isRun[0]);
    }

    @Test
    public void testSetMoreValves() {
        ParsePipeline parsePipeline = new ParsePipeline(null);
        final int[] add = {0};
        parsePipeline.setBasic(createValve(c -> {
            assertEquals(1, add[0]);
            add[0]++;
        }));
        parsePipeline.addValve(createValve(c -> {
            add[0]++;
            c.invokeNext();
        }));
        parsePipeline.invokeParse();
        assertEquals(2, add[0]);
    }

    private BaseValve createValve(Consumer<ValveContext> consumer) {
        return new BaseValve() {
            @Override
            public void invoke(ValveContext context) {
                consumer.accept(context);
            }
        };
    }
}
