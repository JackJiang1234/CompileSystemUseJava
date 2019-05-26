package com.toyc.inter;

import com.toyc.symbol.MethodSymbol;

/**
 * 表示过程调用
 */
public class ProcInstruction extends JustArg1InterInstruction {
    public ProcInstruction(MethodSymbol m) {
        super(Op.PROC, m.getName());
        this.method = m;
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public MethodSymbol getMethod() {
        return method;
    }

    private final MethodSymbol method;
}
