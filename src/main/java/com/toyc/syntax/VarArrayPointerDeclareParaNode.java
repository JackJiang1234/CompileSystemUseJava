package com.toyc.syntax;

/**
 * @ClassName: VarArrayPointerDeclareParaNode
 * @Description  变量，指针，数组参数列表
 *   <para>	->	<type> <paradata> <paralist>
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class VarArrayPointerDeclareParaNode extends ParaNode{
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public VarArrayPointerDeclareParaNode withTypeNode(TypeNode typeNode){
        this.typeNode = typeNode;
        return this;
    }

    public VarArrayPointerDeclareParaNode withParaListNode(ParaListNode paraListNode){
        this.paraListNode = paraListNode;
        return this;
    }

    private TypeNode typeNode;
    private ParaDataNode paraDataNode;
    private ParaListNode paraListNode;
}
