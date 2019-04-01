package com.toyc.syntax;

public interface SyntaxTreeVisitor {
    void visit(ProgramNode node);

    void visit(SegmentNode node);

    void visit(IntNode intNode);
}
