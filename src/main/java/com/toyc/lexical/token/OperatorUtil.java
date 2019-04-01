package com.toyc.lexical.token;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: OperatorUtil
 * @Description TODO
 * http://www.fhdq.net/bd/16.html
 * @Author jianyong.jiang
 * @Date 2019/3/30
 * @Version 1.0.0
 */
public final class OperatorUtil {
    public static final char MUL = '*';
    public static final char DIV = '/';
    public static final char MOD = '%';
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char NOT = '!';
    public static final char ASSIGN = '=';
    public static final char LEA = '&';
    public static final char VERTICAL = '|';
    public static final char GT = '>';
    public static final char LT = '<';
    public static final char LEFT_PARENTHESE = '(';
    public static final char RIGHT_PARENTHESE = ')';
    public static final char LEFT_BRACKET = '[';
    public static final char RIGHT_BRACKET = ']';

    public static final String AND = "&&";
    public static final String INC = "++";
    public static final String DEC = "--";
    public static final String OR = "||";
    public static final String GTE = ">=";
    public static final String LTE = "<=";
    public static final String EQU = "==";
    public static final String NOT_EQU = "!=";
    public static final String SINGLE_LINE_COMMENT = "//";
    public static final String MULTILINE_COMMENT = "/*";

    public static boolean isOperator(int ch) {
        return unaryOperatorSet.contains((char) ch);
    }

    public static boolean needGreedyParse(int ch) {
        return greedyCharSet.contains((char) ch);
    }

    public static boolean isEndGreedyChar(int ch) {
        return endGreedyCharSet.contains((char) ch);
    }

    public static boolean isBinaryOperator(String op) {
        return binaryOperatorSet.contains(op);
    }

    public static boolean isSingleLineCommentSymbol(String commentSymbol) {
        return OperatorUtil.SINGLE_LINE_COMMENT.equals(commentSymbol);
    }

    public static boolean isMultilineCommentSymbol(String commentSymbol) {
        return OperatorUtil.MULTILINE_COMMENT.equals(commentSymbol);
    }

    public static boolean isCommentSymbol(String commentSymbol) {
        return isSingleLineCommentSymbol(commentSymbol)
                || isMultilineCommentSymbol(commentSymbol);
    }

    public static Set<Character> getUnaryOperatorSet(){
        return Collections.unmodifiableSet(unaryOperatorSet);
    }

    public static Set<String> getBinaryOperatorSet(){
        return Collections.unmodifiableSet(binaryOperatorSet);
    }

    private static final Set<String> binaryOperatorSet = new HashSet<>();

    private static final Set<Character> greedyCharSet = new HashSet<>();

    private static final Set<Character> endGreedyCharSet = new HashSet<>();

    private static final Set<Character> unaryOperatorSet = new HashSet<Character>();

    static {
        try {
            for (Field f : OperatorUtil.class.getFields()) {
                if (f.getType().equals(char.class)) {
                    unaryOperatorSet.add(f.getChar(null));
                } else if (f.getType().equals(String.class)) {
                    String op = (String) f.get(null);
                    greedyCharSet.add(op.charAt(0));
                    endGreedyCharSet.add(op.charAt(1));
                    binaryOperatorSet.add(op);
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
