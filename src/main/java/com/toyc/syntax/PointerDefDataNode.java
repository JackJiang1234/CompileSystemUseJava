package com.toyc.syntax;

/**
 * @ClassName: PointerDefDataNode
 * @Description MUL ID <init>
 * 省去MUL定义， 隐式包含
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class PointerDefDataNode extends DefDataNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    void setId(String id) {
        this.id = id;
    }

    void setInitNode(InitNode initNode) {
        this.initNode = initNode;
    }

    public String getId() {
        return this.id;
    }

    public InitNode getInitNode() {
        return initNode;
    }

    private String id;
    private InitNode initNode;
}
