package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

/**
 *  为真跳转 if(arg1) goto result
 * */
public class JtInstruction extends JustArg1ResultInterInstruction{
    public JtInstruction(VariableSymbol arg1, int tLabel) {
        super(Op.JT, Integer.toString(tLabel), arg1.getName());
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
