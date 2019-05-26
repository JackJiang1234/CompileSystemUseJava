package com.toyc.inter;

import com.toyc.symbol.MethodSymbol;

/**
 * 无结果值返回
 */
public class RetInstruction extends JustArg1InterInstruction {
    public RetInstruction(MethodSymbol method) {
        super(Op.RET, method.getName());
        this.method = method;
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
