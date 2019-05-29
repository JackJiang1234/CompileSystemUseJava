package com.toyc.semantic;

import com.toyc.inter.AssignInstruction;
import com.toyc.symbol.VariableSymbol;

/**
 * 表示表达式操作
 * */
public abstract class Op extends Expr {
    Op(VariableSymbol arg) {
        super(arg);
    }

    /**
     * 生成化简中间代码
     */
    @Override
    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(this.getType());
        this.emit(new AssignInstruction(t.getArg(), x.getArg()));
        return t;
    }


}
