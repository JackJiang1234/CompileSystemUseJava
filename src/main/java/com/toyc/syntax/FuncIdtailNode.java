package com.toyc.syntax;

/**
 * @ClassName: FuncIdtailNode
 * @Description  函数声明或定义
 *  function -> LEFT_PARENTHESE  <para> RIGHT_PARENTHESE  <funtail>
 * @Author jianyong.jiang
 * @Date 2019/4/2
 * @Version 1.0.0
 */
public class FuncIdtailNode extends IdtailNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public FuncIdtailNode withParaNode(ParaNode paraNode){
        this.paraNode = paraNode;
        return this;
    }

    public FuncIdtailNode withFunTailNode(FunTailNode funTailNode){
        this.funTailNode = funTailNode;
        return this;
    }

    private ParaNode paraNode;
    private FunTailNode funTailNode;
}
