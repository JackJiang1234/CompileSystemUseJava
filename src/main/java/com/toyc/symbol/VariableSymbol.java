package com.toyc.symbol;

/**
 * @Description 表示变量符号
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public class VariableSymbol extends AbstractSymbol {
    public VariableSymbol(String name, Type type) {
        super(name);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public boolean isExtern() {
        return isExtern;
    }

    public void setExtern(boolean extern) {
        isExtern = extern;
    }

    public Object getInitData() {
        return initData;
    }

    public boolean isArray(){
        return this.type.getClass().equals(ArrayType.class);
    }

    public void setInitData(Object initData) {
        this.initData = initData;
    }

    private Type type;
    private boolean isExtern;
    private Object initData;
}
