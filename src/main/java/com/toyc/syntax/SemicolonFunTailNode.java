package com.toyc.syntax;

/**
 * @ClassName: SemicolonFunTailNode
 * @Description 表示方法声明，没有方法体，逗号结尾
 * @Author jianyong.jiang
 * @Date 2019/4/3
 * @Version 1.0.0
 */
public class SemicolonFunTailNode extends FunTailNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }
}
