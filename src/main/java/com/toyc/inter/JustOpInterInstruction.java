package com.toyc.inter;

import java.io.PrintStream;

/**
 * @Description 仅操作指令
 * @Author jianyong.jiang
 * @Date 2019/5/22
 * @Version 1.0.0
 */
public class JustOpInterInstruction extends BaseInterInstruction {
    public JustOpInterInstruction(Op op) {
        super(op);
    }

    @Override
    public void render(PrintStream out) {
        out.println(this.getOp().getInstructionFormat());
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }
}
