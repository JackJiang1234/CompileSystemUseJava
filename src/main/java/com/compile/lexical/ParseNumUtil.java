package com.compile.lexical;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 解析数字工具类
 *
 * @author jianyong.jiang
 * @date 2019/03/20
 */
public final class ParseNumUtil {
    private static final Map<Character, Integer> NUMBER_MAP = new HashMap<Character, Integer>() {
        {
            put('0', 0);
            put('1', 1);
            put('2', 1);
            put('3', 1);
            put('4', 1);
            put('5', 1);
            put('6', 1);
            put('7', 1);
            put('8', 1);
            put('9', 1);
        }
    };
}
