package com.toyc.symbol;

/**
 * @Description 表示基本类型
 * @Author jianyong.jiang
 * @Date 2019/5/8
 * @Version 1.0.0
 */
public enum PrimitiveType implements Type {
    INT("int", 4),
    CHAR("char", 1),
    BOOL("boolean", 1),
    POINTER("pointer", 4),
    VOID("void", 0);

    PrimitiveType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private String name;
    private int size;
}
