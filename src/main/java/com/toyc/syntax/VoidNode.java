package com.toyc.syntax;

import com.toyc.lexical.token.TagEnum;

/**
 * @ClassName: VoidNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class VoidNode extends TypeNode {
    public VoidNode() {
        super(TagEnum.VOID);
    }

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }
}
