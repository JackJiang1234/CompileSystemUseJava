package com.toyc.symbol;

/**
 * @Description 表示变量符号
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public class VariableSymbol extends AbstractSymbol {
    public VariableSymbol(String name, Type type) {
        this(name, type, false);
    }

    public VariableSymbol(String name, Type type, boolean isPointer){
        super(name);
        this.type = type;
        this.isPointer = isPointer;
    }

    public Type getType() {
        return type;
    }

    public Object getInitData() {
        return initData;
    }

    public boolean isPointer(){
        return this.isPointer;
    }

    public boolean isArray(){
        return this.type.getClass().equals(ArrayType.class);
    }

    public void setInitData(Object initData) {
        this.initData = initData;
    }

    private Type type;
    private Object initData;
    private boolean isPointer;
}
