package com.toyc.syntax;

import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.KeywordEnum;

/**
 * @ClassName: TypeNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class TypeNode extends SyntaxNode {

    public TypeNode(KeywordEnum typeKeyword) {
        this.typeKeyword = typeKeyword;
    }

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    private KeywordEnum typeKeyword;
}
