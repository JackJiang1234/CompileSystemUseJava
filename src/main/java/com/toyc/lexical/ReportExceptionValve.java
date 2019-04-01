package com.toyc.lexical;

public class ReportExceptionValve extends BaseValve {
    @Override
    public void invoke(ValveContext context) {
        throw new LexicalParseException("you must set the basic valve");
    }
}
