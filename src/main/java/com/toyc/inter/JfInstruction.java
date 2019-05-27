package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  为假跳转 if(arg1) goto result
 * */
public class JfInstruction extends JustArg1ResultInterInstruction{
    public JfInstruction(VariableSymbol arg1, int fLabel) {
        super(Op.JF, arg1.getName(), Integer.toString(fLabel));
        this.arg1 = arg1;
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public VariableSymbol getArg1() {
        return arg1;
    }

    private VariableSymbol arg1;
}
