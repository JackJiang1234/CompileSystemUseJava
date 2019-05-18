package com.toyc.inter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * */
public class InterInstructionFactoryTest {

    @Test
    public void testCreateLabel() {
        LabelInterInstruction interInstruction = factory.createLabel();
        assertNotNull(interInstruction);
        assertEquals(factory.getLabCount() - 1, interInstruction.getLabel());
    }

    private InterInstructionFactory factory = InterInstructionFactory.getInstance();
}
