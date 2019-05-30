package com.toyc.symbol;

import com.toyc.lexical.token.Tag;

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

    public static Type mapTypeByTag(Tag tag) {
        if (tag.equals(Tag.INT)) {
            return PrimitiveType.INT;
        } else if (tag.equals(Tag.CHAR)) {
            return PrimitiveType.CHAR;
        } else if (tag.equals(Tag.VOID)) {
            return PrimitiveType.VOID;
        } else {
            throw new RuntimeException("error type tag:" + tag);
        }
    }

    private String name;
    private int size;
}
