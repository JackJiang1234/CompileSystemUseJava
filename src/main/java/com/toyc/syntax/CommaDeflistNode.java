package com.toyc.syntax;

import com.toyc.common.CollectionUtil;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName: CommaDeflistNode
 * @Description 产生式 COMMA <defdata> <deflist>
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class CommaDeflistNode extends DeflistNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public CommaDeflistNode withDefData(DefDataNode node){
        this.defDataNode = node;
        return this;
    }

    public CommaDeflistNode withDeflistNode(DeflistNode node){
        this.deflistNode = node;
        return this;
    }

    public DefDataNode getDefDataNode(){
        return this.defDataNode;
    }

    private DefDataNode defDataNode;
    private DeflistNode deflistNode;
}
