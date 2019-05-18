package com.toyc.inter;

/**
 * 表示中间指令工厂
 */
public class InterInstructionFactory {
    public LabelInterInstruction createLabel() {
        return new LabelInterInstruction(labCount++);
    }

    public static InterInstructionFactory getInstance() {
        return instance;
    }

    public int getLabCount(){
        return labCount;
    }

    private static final InterInstructionFactory instance = new InterInstructionFactory();

    private InterInstructionFactory() {
    }

    private static int labCount = 0;
}
