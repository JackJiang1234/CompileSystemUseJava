package com.toyc.semantic;

import com.toyc.symbol.PrimitiveType;
import com.toyc.symbol.Type;
import com.toyc.symbol.VariableSymbol;

/**
 * 表示赋值语句
 */
public class Assign extends Stmt {
    public Assign(VariableSymbol id, Expr x) {
        this.id = id;
        expr = x;
        if (check(id.getType(), expr.getType()) == null) {
            throw new RuntimeException("type error");
        }
    }

    public Type check(Type p1, Type p2) {
        if (PrimitiveType.numeric(p1) && PrimitiveType.numeric(p2)) {
            return p2;
        } else if (p1 == PrimitiveType.BOOL && p2.equals(PrimitiveType.BOOL)) {
            return p2;
        } else {
            return null;
        }
    }

    public void gen(int b, int a) {

    }

    private VariableSymbol id;
    private Expr expr;
}
