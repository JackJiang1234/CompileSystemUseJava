package lexical;

import java.util.*;

/**
 * 测试是否关键字
 * 
 * @author jianyong.jiang
 * */
public final class KeywordMaps {
	public static final Map<String, TagEnum> Keywords = new HashMap<String, TagEnum>(); 
	
	static {
		Keywords.put("int", TagEnum.KW_INT);
		Keywords.put("char", TagEnum.KW_CHAR);
		Keywords.put("void", TagEnum.KW_VOID);
		Keywords.put("extern", TagEnum.KW_EXTERN);
		Keywords.put("if", TagEnum.KW_IF);
		Keywords.put("else", TagEnum.KW_ELSE);
		Keywords.put("switch", TagEnum.KW_SWITCH);
		Keywords.put("case", TagEnum.KW_CASE);
		Keywords.put("default", TagEnum.KW_DEFAULT);
		Keywords.put("while", TagEnum.KW_WHILE);
		Keywords.put("do", TagEnum.KW_DO);
		Keywords.put("for", TagEnum.KW_FOR);
		Keywords.put("break", TagEnum.KW_BREAK);
		Keywords.put("continue", TagEnum.KW_CONTINUE);
		Keywords.put("return", TagEnum.KW_RETURN);
	}
	
	public static TagEnum getTag(String id){
		return Keywords.containsKey(id) ? Keywords.get(id) : TagEnum.ID;
	}
}
