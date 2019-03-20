package com.compile.lexical.token;

import java.util.HashMap;

/**
 * @ClassName: KeywordUtils
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public final class KeywordUtils {

    private static HashMap<String, KeywordEnum> keywordEnumHashMap = new HashMap<>();

    static {
        for(KeywordEnum key : KeywordEnum.values()){
            keywordEnumHashMap.put(key.getName(), key);
        }
    }

    public static KeywordEnum getKeywordEnumByName(String name) {
        return keywordEnumHashMap.get(name);
    }
}
