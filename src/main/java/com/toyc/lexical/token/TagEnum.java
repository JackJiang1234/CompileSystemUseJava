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
    CHAR, VOID, INT,
    BREAK, ELSE, CONTINUE,
    EXTERN, IF, IN, OUT,
    RETURN, STRING, WHILE,

    // separator
    // COMMA = ','
    // SEMICOLON = ';'
    // LEFT_BRACE = '{'
    // RIGHT_BRACE = '}'
    COMMA, SEMICOLON, LEFT_BRACE, RIGHT_BRACE,

    // operator
    //  MUL = '*';  DIV = '/';   MOD = '%';
    //  PLUS = '+'; MINUS = '-'; NOT = '!';
    //  ASSIGN = '='; LEA = '&'; VERTICAL = '|';
    //  GT = '>'; LT = '<'; LEFT_PARENTHESE = '(';
    //  RIGHT_PARENTHESE = ')'; LEFT_BRACKET = '[';
    //  RIGHT_BRACKET = ']';
    MUL, DIV, MOD, PLUS, MINUS,
    NOT, ASSIGN, LEA, VERTICAL, GT,
    LT, LEFT_PARENTHESE, RIGHT_PARENTHESE, LEFT_BRACKET,
    RIGHT_BRACKET,

    // binary
    AND, INC, DEC, OR, GTE, LTE, EQU, NOT_EQU, SINGLE_LINE_COMMENT, MULTILINE_COMMENT,

    ID, NUMBER, ERROR, END
}
