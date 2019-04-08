package com.toyc.lexical.token;

import com.toyc.lexical.LexicalParseException;

import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 * @ClassName: KeywordUtils
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public final class KeywordUtils {
    public static TagEnum getTagEnumByName(String name){
        return keywordTagMap.get(name);
    }

    public static KeywordToken createTokenByName(String name){
        if (keywordTagMap.containsKey(name)){
            return new KeywordToken(name, keywordTagMap.get(name));
        }
        throw new LexicalParseException("unknown keyword " +  name);
    }

    public static Set<String> getKeywordSet(){
        return Collections.unmodifiableSet(keywordTagMap.keySet());
    }

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
}
