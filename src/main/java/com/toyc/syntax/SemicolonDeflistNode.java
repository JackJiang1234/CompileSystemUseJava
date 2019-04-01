package com.toyc.syntax;

/**
 * @ClassName: SemicolonDeflistNode
 * @Description 匹配逗号，表示变量列表定义终止
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class SemicolonDeflistNode extends DeflistNode {
    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }
}
