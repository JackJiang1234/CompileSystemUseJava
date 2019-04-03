package com.toyc.syntax;

/**
 * @ClassName: VarArrayParaDataNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class VarArrayParaDataNode extends ParaDataNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public VarArrayParaDataNode withIdNode(IdNode idNode){
        this.idNode = idNode;
        return this;
    }

    public VarArrayParaDataNode withParaDataTailNode(ParaDataTailNode paraDataTailNode){
        this.paraDataTailNode = paraDataTailNode;
        return this;
    }

    private IdNode idNode;
    private ParaDataTailNode paraDataTailNode;
}
