package com.toyc.syntax;

/**
 * @ClassName: SyntaxNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public abstract class SyntaxNode {
    public abstract void visit(SyntaxTreeVisitor visitor);
}
