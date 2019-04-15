package com.toyc.syntax;

/**
 * @ClassName: PointerDefNode
 * @Description 指针定义开头
 * 产生式  MUL ID <init> <deflist>
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class PointerDefNode extends DefNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public InitNode getInitNode() {
        return this.initNode;
    }

    void setInitNode(InitNode node) {
        if (this.initNode != null) {
            throw new SyntaxParsingException("initNode node has been set.");
        } else {
            this.initNode = node;
        }
    }

    private InitNode initNode;
}
