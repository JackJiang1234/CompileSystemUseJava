package com.toyc.syntax;

import com.toyc.common.CollectionUtil;

import java.util.List;

/**
 * @ClassName: StatementSubProgramNode
 * @Description 程序语句
 * <subprogram>	->	<statement> <subprogram>
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class StatementSubProgramNode extends SubProgramNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    public StatementSubProgramNode withStatementNode(StatementNode statementNode){
        this.statementNodes = CollectionUtil.createIfNull(this.statementNodes);
        this.statementNodes.add(statementNode);
        return this;
    }

    private List<StatementNode> statementNodes;
}
