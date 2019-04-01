package com.toyc.lexical;

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

    public static final Map<Character, Integer> OCT_NUMBER_MAP = new HashMap<Character, Integer>() {
        {
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
        }
    };

    public static final Map<Character, Integer> DECIMAL_NUMBER_MAP = new HashMap<Character, Integer>(OCT_NUMBER_MAP) {
        {
            put('8', 8);
            put('9', 9);
        }
    };

    public static final Map<Character, Integer> HEX_NUMBER_MAP = new HashMap<Character, Integer>(DECIMAL_NUMBER_MAP) {
        {
            put('a', 10);
            put('b', 11);
            put('c', 12);
            put('d', 13);
            put('e', 14);
            put('f', 15);
        }
    };

    public static Integer getDecimalNumberByChar(int decimalChar) {
        return DECIMAL_NUMBER_MAP.get((char) decimalChar);
    }

    public static Integer getHexNumberByChar(int hexChar) {
        return HEX_NUMBER_MAP.get((char) hexChar);
    }

    public static Integer getOctNumberByChar(int octChar) {
        return OCT_NUMBER_MAP.get((char) octChar);
    }
}
