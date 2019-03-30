package com.compile.lexical.token;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * ! exclamation 惊叹号
 * @ at 单价
 * # number …号
 * () parentheses 圆括号
 * _ hyphen 连字符
 * [] square brackets 方括号
 * : colon 冒号
 * ; semicolon 分号
 * "" double quotation marks 双引号
 * ¨tandem colon 双点号
 * "ditto
 */
public final class SeparatorUtil {
    public static final char COMMA = ',';
    public static final char SEMICOLON = ';';
    public static final char LEFT_BRACKET = '{';
    public static final char RIGHT_BRACKET = '}';

    public static boolean isSeparator(int test){
        return SeparatorUtil.separatorSet.contains((char)test);
    }

    public static Set<Character> getSeparators(){
        return Collections.unmodifiableSet(separatorSet);
    }

    private static final Set<Character> separatorSet = new HashSet<Character>(){{
        add(SeparatorUtil.COMMA);
        add(SeparatorUtil.SEMICOLON);
        add(SeparatorUtil.LEFT_BRACKET);
        add(SeparatorUtil.RIGHT_BRACKET);
    }};
}
