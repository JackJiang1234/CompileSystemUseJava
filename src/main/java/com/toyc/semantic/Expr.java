package com.toyc.semantic;

import com.toyc.inter.JfInstruction;
import com.toyc.inter.JmpInstruction;
import com.toyc.inter.JtInstruction;
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
     * 返回一个结果，该结果可以成为三地址指令的右部
     * E = E1 + E2  方法gen返回x1 + x2, x1和x2分别存放E1和E2值的地址
     */
    public Expr gen() {
        return this;
    }

    /**
     * 表达式归约为单一地址
     * 返回一个常量，一个标识符，或都一个临时的名称
     * 给定一个表达式E, 返回一个存放E的值临时变量
     */
    public Expr reduce() {
        return this;
    }

    /**
     * 获取表达式类型
     * */
    public Type getType() {
        return this.arg.getType();
    }

    /**
     * 根据true或false label生成跳转指令
     */
    public void jumping(int tLabel, int fLabel){

    }

    /**
     * t和f的label数值和test生成跳转指令
     */
    protected final void emitJumps(VariableSymbol test, int tLabel, int fLabel) {
        if (tLabel != 0 && fLabel != 0) {
            this.emit(new JtInstruction(test, tLabel));
            this.emit(new JmpInstruction(fLabel));
        } else if (tLabel != 0) {
            this.emit(new JtInstruction(test, tLabel));
        } else if (fLabel != 0) {
            this.emit(new JfInstruction(test, fLabel));
        }
    }

    public VariableSymbol getArg() {
        return arg;
    }

    private VariableSymbol arg;
}
