package com.toyc.inter;

import com.toyc.symbol.MethodSymbol;
import com.toyc.symbol.VariableSymbol;

/**
 *  表示函数调用有返回值
 * */
public class CallInstruction extends JustArg1ResultInterInstruction{
    public CallInstruction(VariableSymbol result, MethodSymbol m) {
        super(Op.CALL, result.getName(), m.getName());
        this.resutl = result;
        this.method = m;
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public VariableSymbol getResutl() {
        return resutl;
    }

    public MethodSymbol getMethod() {
        return method;
    }

    private VariableSymbol resutl;
    private MethodSymbol method;
}
