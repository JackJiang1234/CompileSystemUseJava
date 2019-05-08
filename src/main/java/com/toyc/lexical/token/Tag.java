package com.toyc.lexical.token;

/**
 * @ClassName: Tag
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/4
 * @Version 1.0.0
 */
public enum Tag {
    // keyword
    CHAR, VOID, INT,
    BREAK, ELSE, CONTINUE,
    EXTERN, IF, IN, OUT,
    RETURN, STRING, WHILE,

    // separator
    // COMMA = ','
    // SEMICOLON = ';'
    // COLON = ':'
    // LEFT_BRACE = '{'
    // RIGHT_BRACE = '}'
    COMMA, SEMICOLON, COLON,LEFT_BRACE, RIGHT_BRACE,

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
    AND, INCR, DECR, OR, GTE, LTE, EQU, NOT_EQU, SINGLE_LINE_COMMENT, MULTILINE_COMMENT,

    ID, NUMBER, ERROR, END
}
