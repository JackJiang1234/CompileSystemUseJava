package com.toyc.context;

/**
 * @ClassName: TypeEnum
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/5/7
 * @Version 1.0.0
 */
public enum TypeEnum {
    INT("int", 4),
    CHAR("char", 1),
    BOOL("boolean", 1),
    POINTER("pointer", 4);

    TypeEnum(String name, int width){
        this.name = name;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    private String name;
    private int width;
}
