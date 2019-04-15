package com.toyc.syntax;

/**
 * @ClassName: DeflistNode
 * @Description <deflist> -> COMMA <defdata> <deflist> | SEMICOLON
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class DeflistNode extends SyntaxNode{
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public void setDefDataNode(DefDataNode defDataNode){
        this.defDataNode = defDataNode;
    }

    public void setDeflistNode(DeflistNode deflistNode){
        this.deflistNode = deflistNode;
    }

    private DefDataNode defDataNode;
    private DeflistNode deflistNode;
}
