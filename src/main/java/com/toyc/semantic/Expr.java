package com.toyc.semantic;

import com.toyc.inter.InterInstruction;
import com.toyc.inter.JustArg1ResultInterInstruction;
import com.toyc.inter.Op;
import com.toyc.lexical.token.Tag;
import com.toyc.symbol.Type;
import com.toyc.symbol.VariableSymbol;

/**
 * 表达式生成抽象基类
 */
public abstract class Expr extends AbstractRuleNode {
    private Tag op;
    private Type type;

    Expr(Tag op, Type t) {
        this.op = op;
        this.type = t;
    }

    /**
     * 生成中间代码
     */
    public Expr gen() {
        return this;
    }

    /**
     * 生成化简中间代码
     */
    public Expr reduce() {
        return this;
    }

    /**
     * 根据true或false label生成跳转指令
     */
    public void jumping(int tLabel, int fLabel) {
        //emitJumms();
    }

    /**
     * t和f的label数值和test生成跳转指令
     */
    protected final void emitJumms(VariableSymbol test, int tLabel, int fLabel) {
        if (tLabel != 0 && fLabel != 0) {
            //InterInstruction instruction = new JustArg1ResultInterInstruction(Op.JT, test, );
        }
    }
}
