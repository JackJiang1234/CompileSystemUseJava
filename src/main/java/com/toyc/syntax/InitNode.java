package com.toyc.syntax;

/**
 * @ClassName: InitNode
 * @Description  赋值
 * 产生式  ASSIGN <expr> | EMPTY
 * 未定义 ASSIGN结点，隐含
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class InitNode extends SyntaxNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public InitNode withExprNode(ExprNode node) {
        this.exprNode = node;
        return this;
    }

    public ExprNode getExprNode() {
        return this.exprNode;
    }

    private ExprNode exprNode;
}
