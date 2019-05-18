package com.toyc.inter;

/**
 * 表示指令访问者
 * */
public interface InterInstructionVisitor {
    void visit(LabelInterInstruction label);
}
