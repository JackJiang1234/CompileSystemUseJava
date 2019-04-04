package com.toyc.lexical.token;

/**
 * @ClassName: TagEnum
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/4
 * @Version 1.0.0
 */
public enum TagEnum {
    // keyword
    CHAR(true, false), VOID(true, false), INT(true, false),
    BREAK(true, false), ELSE(true, false), CONTINUE(true, false),
    EXTERN(true, false), IF(true, false), IN(true, false), OUT(true, false),
    RETURN(true, false), STRING(true, false), WHILE(true, false),

    // separator
    // COMMA = ','
    // SEMICOLON = ';'
    // LEFT_BRACE = '{'
    // RIGHT_BRACE = '}'
    COMMA(false, true), SEMICOLON(false, true), LEFT_BRACE(false, true), RIGHT_BRACE(false, true),

    // operator
    //  MUL = '*';  DIV = '/';   MOD = '%';
    //  PLUS = '+'; MINUS = '-'; NOT = '!';
    //  ASSIGN = '='; LEA = '&'; VERTICAL = '|';
    //  GT = '>'; LT = '<'; LEFT_PARENTHESE = '(';
    //  RIGHT_PARENTHESE = ')'; LEFT_BRACKET = '[';
    //  RIGHT_BRACKET = ']';
    MUL(false, false), DIV(false, false), MOD(false, false), PLUS(false, false), MINUS(false, false),
    NOT(false, false), ASSIGN(false, false), LEA(false, false), VERTICAL(false, false), GT(false, false),
    LT(false, false), LEFT_PARENTHESE(false, false), RIGHT_PARENTHESE(false, false), LEFT_BRACKET(false, false),
    RIGHT_BRACKET(false, false);

    public boolean isSeparator() {
        return this.isSeparator;
    }

    public boolean isKeyword() {
        return this.isKeyword;
    }


    TagEnum(boolean isKeyword, boolean isSeparator) {
        this.isKeyword = isKeyword;
        this.isSeparator = isSeparator;
    }

    private boolean isKeyword;
    private boolean isSeparator;
}
