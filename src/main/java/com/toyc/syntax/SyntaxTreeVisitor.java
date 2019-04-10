package com.toyc.syntax;

public interface SyntaxTreeVisitor {
    void visit(ProgramNode node);

    void visit(SegmentNode node);

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

    void visit(ArrayDefNode arrayVarDefNode);

    void visit(NumNode numNode);

    void visit(InitVarArrayDefNode initVarDefNode);

    void visit(VarOrArrDefIdTailNode varOrArrDefIdtailNode);

    void visit(FuncIdTailNode funcIdtailNode);

    void visit(VarArrayPointerDeclareParaNode varArrayPointerDeclareParaNode);

    void visit(PointerParaDataNode pointerParaDataNode);

    void visit(VarArrayParaDataNode varArrayParaDataNode);

    void visit(ParaDataTailNode paraDataTailNode);

    void visit(ParaListNode paraListNode);

    void visit(ParaDeclareNode paraDeclareNode);

    void visit(BlockFunTailNode blockFunTailNode);

    void visit(SemicolonFunTailNode semicolonFunTailNode);

    void visit(LocalDefSubProgramNode localDefSubProgramNode);

    void visit(StatementSubProgramNode statementSubProgramNode);

    void visit(LocalDefNode localDefNode);

    void visit(TypeNode typeNode);
}
