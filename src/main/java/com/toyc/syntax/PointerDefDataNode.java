package com.toyc.syntax;

/**
 * @ClassName: PointerDefDataNode
 * @Description MUL ID <init>
 *     省去MUL定义， 隐式包含
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class PointerDefDataNode extends DefDataNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public PointerDefDataNode withIdNode(IdNode node){
        this.idNode = node;

        return this;
    }

    public PointerDefDataNode withInitNode(InitNode initNode){
        this.initNode = initNode;
        return this;
    }

    private IdNode idNode;
    private InitNode initNode;
}
