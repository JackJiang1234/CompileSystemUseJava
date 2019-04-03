package com.toyc.syntax;

/**
 * @ClassName: ParaDataTailNode
 * @Description 数组声明
 * <paradatatail> -> LEFT_BRACKET   NUM   RIGHT_BRACKET  |  EMPTY
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class ParaDataTailNode extends SyntaxNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public ParaDataTailNode withNumNode(NumNode numNode) {
        this.numNode = numNode;
        return this;
    }

    private NumNode numNode;
}
