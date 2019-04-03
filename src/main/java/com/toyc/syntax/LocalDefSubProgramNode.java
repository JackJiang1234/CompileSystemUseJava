package com.toyc.syntax;

import com.toyc.common.CollectionUtil;

import java.util.List;

/**
 * @ClassName: LocalDefSubProgramNode
 * @Description 局部变量列表
 * <subprogram>	->	<localdef> <subprogram>
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class LocalDefSubProgramNode extends SubProgramNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public LocalDefSubProgramNode withLocalDefNode(LocalDefNode localDefNode){
        this.localDefNodes = CollectionUtil.createIfNull(this.localDefNodes);
        this.localDefNodes.add(localDefNode);

        return this;
    }

    private List<LocalDefNode> localDefNodes;
}

