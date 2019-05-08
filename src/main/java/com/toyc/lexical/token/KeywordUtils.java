package com.toyc.lexical.token;

import com.toyc.lexical.LexicalParseException;

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
    public static Tag getTagEnumByName(String name){
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

    private static HashMap<String, Tag> keywordTagMap = new HashMap<String, Tag>() {{
        put("char", Tag.CHAR);
        put("void", Tag.VOID);
        put("int", Tag.INT);
        put("break", Tag.BREAK);
        put("else", Tag.ELSE);
        put("continue", Tag.CONTINUE);
        put("extern", Tag.EXTERN);
        put("if", Tag.IF);
        put("in", Tag.IN);
        put("out", Tag.OUT);
        put("return", Tag.RETURN);
        put("string", Tag.STRING);
        put("while", Tag.WHILE);
    }};
}
