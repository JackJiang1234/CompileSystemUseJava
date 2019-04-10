package com.toyc.syntax;

import com.toyc.lexical.token.TagEnum;

/**
 * @ClassName: TypeNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class TypeNode extends SyntaxNode {

    public TypeNode(TagEnum typeTag) {
        this.typeTag = typeTag;
    }

    public boolean isInt(){
        return this.typeTag == TagEnum.INT;
    }

    public boolean isChar(){
        return this.typeTag == TagEnum.CHAR;
    }

    public boolean isVoid(){
        return this.typeTag == TagEnum.VOID;
    }

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    private TagEnum typeTag;
}
