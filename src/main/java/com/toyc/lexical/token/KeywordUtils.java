package com.toyc.lexical.token;

import java.util.HashMap;

/**
 * @ClassName: KeywordUtils
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public final class KeywordUtils {
    private static HashMap<String, TagEnum> keywordTagMap = new HashMap<String, TagEnum>() {{
        put("char", TagEnum.CHAR);
        put("void", TagEnum.VOID);
        put("int", TagEnum.INT);
        put("break", TagEnum.BREAK);
        put("else", TagEnum.ELSE);
        put("continue", TagEnum.CONTINUE);
        put("extern", TagEnum.EXTERN);
        put("if", TagEnum.IF);
        put("in", TagEnum.IN);
        put("out", TagEnum.OUT);
        put("return", TagEnum.RETURN);
        put("string", TagEnum.STRING);
        put("while", TagEnum.WHILE);
    }};
    private static HashMap<String, KeywordEnum> keywordEnumHashMap = new HashMap<>();

    static {
        for (KeywordEnum key : KeywordEnum.values()) {
            keywordEnumHashMap.put(key.getName(), key);
        }
    }

    public static TagEnum getTagEnumByName(String name){
        return keywordTagMap.get(name);
    }

    public static KeywordEnum getKeywordEnumByName(String name) {
        return keywordEnumHashMap.get(name);
    }
}
