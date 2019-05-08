package com.toyc.symbol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 表示聚合类型
 * @Author jianyong.jiang
 * @Date 2019/5/8
 * @Version 1.0.0
 */
public class AggregateType implements Type {
    public AggregateType(String name){
        this.name = name;
        this.types = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.types.stream().mapToInt(t -> t.getSize()).sum();
    }

    public void Add(Type t){
        this.types.add(t);
    }

    public List<Type> getTypes(){
        return Collections.unmodifiableList(types);
    }

    private String name;
    private ArrayList<Type> types;
}
