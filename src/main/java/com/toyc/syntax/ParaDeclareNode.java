package com.toyc.syntax;

/**
 * @ClassName: ParaDeclareNode
 * @Description 表示一个参数声明
 * 产生式 COMMA  <type>  <paradata>
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class ParaDeclareNode extends SyntaxNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public ParaDeclareNode withTypeNode(TypeNode typeNode){
        this.typeNode = typeNode;
        return this;
    }

    public ParaDeclareNode withParaDataNode(ParaDataNode paraDataNode){
        this.paraDataNode = paraDataNode;
        return this;
    }

    private TypeNode typeNode;
    private ParaDataNode paraDataNode;
}
