package com.toyc.syntax;

/**
 * @ClassName: IdNode
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class IdNode extends SyntaxNode{

    public IdNode(String name){
        this.name = name;
    }

    @Override
    public void visit(SyntaxTreeVisitor visitor) {
        visitor.visit(this);
    }

    private String name;
}
