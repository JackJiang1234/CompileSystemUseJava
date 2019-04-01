package com.toyc.syntax;

public interface SyntaxTreeVisitor {
    void visit(ProgramNode node);

    void visit(SegmentNode node);

    void visit(IntNode intNode);

    void visit(CharNode charNode);

    void visit(VoidNode voidNode);

    void visit(PointerDefNode pointerDefNode);

    void visit(IdNode idNode);

    void visit(NonPointerDefNode nonPointerDefNode);

    void visit(InitNode initNode);

    void visit(ExprNode exprNode);

    void visit(CommaDeflistNode commaDeflistNode);

    void visit(SemicolonDeflistNode semicolonDeflistNode);

    void visit(PointerDefDataNode pointerDefDataNode);

    void visit(NonPointerDefDataNode nonPointerDefDataNode);

    void visit(ArrayVarDefNode arrayVarDefNode);

    void visit(NumNode numNode);

    void visit(InitVarDefNode initVarDefNode);
}
