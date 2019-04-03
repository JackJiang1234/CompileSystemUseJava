package com.toyc.syntax;

/**
 * @ClassName: PointerParaDataNode
 * @Description 表示指针变量声明
 * 产生式 MUL ID, 隐式包含MUL结点
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class PointerParaDataNode extends ParaDataNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public PointerParaDataNode withIdNode(IdNode idNode) {
        this.idNode = idNode;
        return this;
    }

    private IdNode idNode;
}
