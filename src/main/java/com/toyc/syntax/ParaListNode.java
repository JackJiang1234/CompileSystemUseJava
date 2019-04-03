package com.toyc.syntax;

import com.toyc.common.CollectionUtil;

import java.util.List;

/**
 * @ClassName: ParaListNode
 * @Description   参数列表
 * <paralist>		->	COMMA  <type>  <paradata>  <paralist> |  EMPTY
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class ParaListNode extends SyntaxNode{

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public ParaListNode withParaDelcareNode(ParaDeclareNode paraDeclareNode){
        this.paraDeclareNodes = CollectionUtil.createIfNull(this.paraDeclareNodes);
        this.paraDeclareNodes.add(paraDeclareNode);
        return this;
    }

    private List<ParaDeclareNode> paraDeclareNodes;
}
