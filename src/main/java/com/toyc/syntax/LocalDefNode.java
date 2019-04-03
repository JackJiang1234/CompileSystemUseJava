package com.toyc.syntax;

/**
 * @ClassName: LocalDefNode
 * @Description 局部变量定义
 * <localdef>	->	<type><defdata><deflist>
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class LocalDefNode extends SyntaxNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public LocalDefNode withTypeNode(TypeNode node) {
        this.typeNode = node;
        return this;
    }

    public LocalDefNode withDefDataNode(DefDataNode defDataNode){
        this.defDataNode = defDataNode;
        return this;
    }

    public LocalDefNode withDefListNode(DeflistNode defListNode){
        this.deflistNode = defListNode;
        return this;
    }

    private TypeNode typeNode;
    private DefDataNode defDataNode;
    private DeflistNode deflistNode;
}
