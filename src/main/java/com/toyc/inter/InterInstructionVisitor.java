package com.toyc.inter;

/**
 * 表示指令访问者
 * */
public interface InterInstructionVisitor {

    void visit(NopInstruction nopInstruction);

    void visit(LabelInstruction interInstruction);

    void visit(JmpInstruction jmpInstruction);

    void visit(DecInstruction decInstruction);

    void visit(EntryInstruction entryInstruction);

    void visit(ExitInstruction exitInstruction);

    void visit(AssignInstruction assignInstruction);

    void visit(AddInstruction addInstruction);

    void visit(SubInstruction subInstruction);

    void visit(MulInstruction mulInstruction);

    void visit(DivInstruction divInstruction);

    void visit(ModInstruction modInstruction);

    void visit(NegInstruction negInstruction);

    void visit(GtInstruction gtInstruction);

    void visit(GeInstruction geInstruction);

    void visit(LtInstruction ltInstruction);

    void visit(LeInstruction leInstruction);

    void visit(EquInstruction equInstruction);

    void visit(NeInstruction neInstruction);

    void visit(NotInstruction notInstruction);

    void visit(AndInstruction andInstruction);

    void visit(OrInstruction orInstruction);

    void visit(LeaInstruction leaInstruction);

    void visit(SetInstruction setInstruction);

    void visit(GetInstruction getInstruction);

    void visit(JtInstruction jtInstruction);

    void visit(JfInstruction jfInstruction);

    void visit(JneInstruction jneInstruction);

    void visit(ArgInstruction argInstruction);

    void visit(ProcInstruction procInstruction);

    void visit(CallInstruction callInstruction);

    void visit(RetInstruction retInstruction);

    void visit(RetvInstruction retvInstruction);
}
