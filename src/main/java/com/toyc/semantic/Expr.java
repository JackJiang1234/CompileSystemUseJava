package com.toyc.semantic;

import com.toyc.inter.*;
import com.toyc.lexical.token.Tag;
import com.toyc.symbol.Type;
import com.toyc.symbol.VariableSymbol;

/**
 * 表达式生成抽象基类
 */
public abstract class Expr extends AbstractRuleNode {

    Expr(VariableSymbol arg) {
        this.arg = arg;
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
        this.emitJumps(this.arg, tLabel, fLabel);
    }

    /**
     * t和f的label数值和test生成跳转指令
     */
    protected final void emitJumps(VariableSymbol test, int tLabel, int fLabel) {
        if (tLabel != 0 && fLabel != 0) {
            this.emit(new JtInstruction(test, tLabel));
            this.emit(new JmpInstruction(fLabel));
        }
        else if (tLabel != 0){
            this.emit(new JtInstruction(test, tLabel));
        }
        else if (fLabel != 0){
            this.emit(new JfInstruction(test, fLabel));
        }
    }

    public VariableSymbol getArg() {
        return arg;
    }

    private VariableSymbol arg;
}
