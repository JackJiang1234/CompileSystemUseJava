package com.toyc.syntax;

/**
 * @ClassName: SegmentNode
 * @Description 程序片断由变量定义，变量声明，函数定义，函数声明组成
 * 产生式     <segment>   ->	EXTERN <type><def> | <type><def>
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class SegmentNode extends SyntaxNode {

    public SegmentNode(boolean isExtern) {
        this.isExtern = isExtern;
    }

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public TypeNode getTypeNode() {
        return this.typeNode;
    }

    public DefNode getDefNode(){
        return this.defNode;
    }

    void setTypeNode(TypeNode node) {
        if (typeNode != null) {
            throw new SyntaxParsingException("type node has been set.");
        } else {
            this.typeNode = node;
        }
    }

    void setDef(DefNode node) {
        if (this.defNode != null) {
            throw new SyntaxParsingException("defNode node has been set.");
        } else {
            this.defNode = node;
        }
    }

    public boolean isExtern() {
        return isExtern;
    }

    private boolean isExtern;
    private TypeNode typeNode;
    private DefNode defNode;
}
