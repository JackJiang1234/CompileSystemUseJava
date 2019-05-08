package com.toyc.symbol;

/**
 * @ClassName: ArrayType
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/5/8
 * @Version 1.0.0
 */
public class ArrayType extends AggregateType {
    public ArrayType(Type type, int length) {
        super("array");
        this.Add(type);
        this.length = length;
    }

    @Override
    public int getSize() {
        return this.getTypes().get(0).getSize() * this.length;
    }

    public int getLength() {
        return this.length;
    }

    private int length;
}
