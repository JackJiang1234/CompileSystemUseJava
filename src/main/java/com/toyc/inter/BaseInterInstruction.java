package com.toyc.inter;

/**
 * 表示中间指令基类
 */
public abstract class BaseInterInstruction implements InterInstruction {
    public BaseInterInstruction(Op op) {
        this.op = op;
    }

    public Op getOp() {
        return op;
    }

    private Op op;

}
