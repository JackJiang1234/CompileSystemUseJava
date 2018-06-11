package lexical;

/**
 * 表示词法标记的类型
 * 
 * @author jianyong.jiang 
 * */
public enum TagEnum {
	// 错误标记， 结束
	ERR, END, 
	
	// 标识符， 数字，字符，字符串
	ID, NUM, CHAR, STRING,
	
	KW_INT, KW_CHAR, KW_VOID, KW_EXTERN, 
	KW_IF, KW_ELSE, 
	KW_SWITCH, KW_CASE, KW_DEFAULT,
	KW_WHILE, KW_DO, KW_FOR, KW_BREAK, KW_CONTINUE,
	KW_RETURN,
	
	// !, &
	NOT, LEA,
	
	// +, -, *, /, %
	ADD, SUB, MUL, DIV, MODE, 
	
	// ++, --
	INC, DEC, 
	
	// >, >=, <, <=, ==, !=
	GT, GE, LT, LE, EQU, NEQU,
	
	// &&, ||
	AND, OR,
	
	// (, )
	LPAREN, RPAREN,
	
	// [, ]
	LBRACK, RBRACK,
	
	// {, }
	LBRACE, RBRACE,
	
	// 逗号,， 冒号:，分号;
	COMMA, COLON, SEMICON,
	
	//赋值=
	ASSIGN
}
