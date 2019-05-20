package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * 一般 四元式指令 result = arg1 op arg2
 */
public class GeneralInstruction extends BaseInterInstruction {
    public GeneralInstruction(Op op, VariableSymbol result, VariableSymbol arg1, VariableSymbol arg2) {
        super(op);
        this.result = result;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    /**
     * 打印中间指令
     *
     * @param out
     */
    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getInstructionFormat(), this.result, this.arg1, this.arg2);
    }

    @Override
    public void visit(InterInstructionVisitor visitor) {
        visitor.visit(this);
    }

    public VariableSymbol getResult() {
        return result;
    }

    public VariableSymbol getArg1() {
        return arg1;
    }

    public VariableSymbol getArg2() {
        return arg2;
    }

    private VariableSymbol result;
    private VariableSymbol arg1;
    private VariableSymbol arg2;
}
