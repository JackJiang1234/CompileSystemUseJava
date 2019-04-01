package com.toyc.lexical.token;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorUtilTest {

    @Test
    void isOperator() {
        char[] operators = new char[]{
                '+', '-', '*', '/', '&', '>', '<', '='
        };
        for (char op : operators) {
            assertTrue(OperatorUtil.isOperator(op));
        }
    }

    @Test
    void isNeedGreedyParse() {
        char[] operators = new char[]{
                '+', '-', '/', '&', '>', '<', '=', '!', '/','|'
        };
        for (char op : operators) {
            assertTrue(OperatorUtil.needGreedyParse(op));
        }
    }

    @Test
    void isEndGreedyParse() {
        char[] operators = new char[]{
                '*','+', '-', '/', '&', '=', '|'
        };
        for (char op : operators) {
            assertTrue(OperatorUtil.isEndGreedyChar(op));
        }
    }

    @Test
    void isValidBinaryOperator() {
        String[] binaries = new String[]{
                "&&", "++", "--", "||", ">=", "<=", "==", "!=", "//", "/*"
        };
        for (String op : binaries) {
            assertTrue(OperatorUtil.isBinaryOperator(op));
        }
    }

    @Test
    void isCommentSymbol() {
        assertTrue(OperatorUtil.isCommentSymbol("//"));
        assertTrue(OperatorUtil.isCommentSymbol("/*"));

        assertFalse(OperatorUtil.isCommentSymbol("||"));
    }
}