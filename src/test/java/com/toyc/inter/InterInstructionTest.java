package com.toyc.inter;

import com.toyc.symbol.PrimitiveType;
import com.toyc.symbol.VariableSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * */
public class InterInstructionTest {

    @Test
    public void testCreateLabel() {
        InterInstruction interInstruction = factory.createLabel();
        LabelInstruction labelInstruction = (LabelInstruction) interInstruction;
        assertNotNull(interInstruction);
        assertEquals(factory.getLabCount() - 1, labelInstruction.getLabel());
    }

    @Test
    public void testInstructionRender() {
        testInstructionRenderImpl(NopInstruction.class, Op.NOP.getRenderFormat());
        testInstructionRenderImpl(DecInstruction.class, "dec a", new VariableSymbol("a", PrimitiveType.INT));
        testInstructionRenderImpl(LabelInstruction.class, ".L1", 1);
        testInstructionRenderImpl(EntryInstruction.class, Op.ENTRY.getRenderFormat());
        testInstructionRenderImpl(ExitInstruction.class, Op.EXIT.getRenderFormat());
        testInstructionRenderImpl(AssignInstruction.class, "a = b",
                new VariableSymbol("a", PrimitiveType.INT), new VariableSymbol("b", PrimitiveType.INT));
        testInstructionRenderImpl(AddInstruction.class, "a = b + c",
                new VariableSymbol("a", PrimitiveType.INT), new VariableSymbol("b", PrimitiveType.INT), new VariableSymbol("c", PrimitiveType.INT));

    }

    @BeforeEach
    public void initForCase() {
        this.outputStream.reset();
        System.setOut(new PrintStream(this.outputStream));
    }

    private void testInstructionRenderImpl(Class instructionClass, String expected, Object... args) {
        this.outputStream.reset();
        try {
            List<Class> classes = Arrays.asList(args).stream().map(arg -> {
                if (arg.getClass().equals(Integer.class)) {
                    return Integer.TYPE;
                } else {
                    return arg.getClass();
                }
            }).collect(Collectors.toList());
            Class[] classesArray = classes.toArray(new Class[classes.size()]);
            Constructor constructor = instructionClass.getConstructor(classesArray);
            InterInstruction instruction = (InterInstruction) constructor.newInstance(args);
            instruction.render(System.out);
            assertEquals(this.getOutInstruction(), expected + NEW_LINE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getOutInstruction() {
        return this.outputStream.toString();
    }

    private final static String NEW_LINE = System.getProperty("line.separator");

    private ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private InterInstructionFactory factory = InterInstructionFactory.getInstance();
}
