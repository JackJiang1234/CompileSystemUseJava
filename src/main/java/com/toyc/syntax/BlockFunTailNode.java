package com.toyc.syntax;

/**
 * @ClassName: BlockFunTailNode
 * @Description 表示方法内容定义
 *  <block>	 ->	LEFT_BRACE <subprogram> RIGHT_BRACE
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class BlockFunTailNode extends FunTailNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public BlockFunTailNode withSubProgramNode(SubProgramNode subProgramNode){
        this.subProgramNode = subProgramNode;
        return this;
    }

    private SubProgramNode subProgramNode;
}
