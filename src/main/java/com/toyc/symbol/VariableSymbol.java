package com.toyc.symbol;

/**
 * @Description 表示变量符号
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public class VariableSymbol extends AbstractSymbol {
    public VariableSymbol(String name, TypeEnum type) {
        super(name);
        this.type = type;
    }

    public TypeEnum getType() {
        return type;
    }

    private TypeEnum type;
    private boolean isArray;
    private boolean isExtern;

}
