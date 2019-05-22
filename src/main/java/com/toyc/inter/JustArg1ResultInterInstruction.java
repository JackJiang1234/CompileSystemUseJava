package com.toyc.inter;

import com.toyc.symbol.VariableSymbol;

import java.io.PrintStream;

/**
 * @ClassName: JustArg1ResultInterInstruction
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/5/22
 * @Version 1.0.0
 */
public class JustArg1ResultInterInstruction extends BaseInterInstruction {
    public JustArg1ResultInterInstruction(Op op, VariableSymbol result, VariableSymbol arg1) {
        super(op);
        this.arg1 = arg1;
        this.result = result;
    }

    @Override
    public void render(PrintStream out) {
        out.format(this.getOp().getInstructionFormat(), this.result, this.arg1);
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

    private VariableSymbol result;
    private VariableSymbol arg1;
}
