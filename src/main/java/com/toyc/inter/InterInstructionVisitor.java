package com.toyc.inter;

/**
 * 表示指令访问者
 * */
public interface InterInstructionVisitor {
    void visit(LabelInterInstruction label);

    void visit(GeneralInstruction generalInstruction);

    void visit(JustOpInterInstruction justOpInterInstruction);

    void visit(JustArg1InterInstruction justArg1InterInstruction);

    void visit(JustArg1ResultInterInstruction justArg1ResultInterInstruction);

    void visit(JustArg1Arg2InterInstruction justArg1Arg2InterInstruction);
}
