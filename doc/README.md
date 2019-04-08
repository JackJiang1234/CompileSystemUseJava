# 语法定义

终结符用大写字母，EMPTY表示空

 非终结符用<小写>

### TOYC程序文法
<program>			->	<segment> <program> |  EMPTY

### 程序由变量定义，变量声明，函数定义，函数声明组成

<segment>			->	EXTERN  <type> <def> | <type> <def>

### 基本类型

<type>				->	INT ｜ CHAR  |  VOID

### 指针定义或其他定义

//  *p=null, a=100, a[10] = 1    |  a = 100

<def>				->	MUL ID <init> <deflist>  | ID  <idtail>

### 初始化值 或 空  如 = 表达式求值
<init>				->	ASSIGN <expr> | EMPTY

### 多变量定义  
 <deflist>			->	COMMA <defdata> <deflist> | SEMICOLON    

// *p=null,a=100,a[10] = 1 指针，变量，数组定义序列

<defdata>			->	ID <varrdef> | MUL ID  <init>

### 基本定义语法

//a=100,a[10]=1 变量 数组 初始化

<varrdef>			->	LEFT_BRACKET NUM  RIGHT_BRACKET |  <init>

//a a[10] 变量和数组定义，其他（函数声明和函数定义）

<idtail>			->	<varrdef><deflist> | LEFT_PARENTHESE <para> RIGHT_PARENTHESE <funtail>

### 函数声明或定义语法

//函数参数列表

<para>				->	<type> <paradata> <paralist> | EMPTY

<paradata>		->	MUL ID  |  ID  <paradatatail>

<paradatatail>->	LEFT_BRACKET   NUM   RIGHT_BRACKET  |  EMPTY

<paralist>		->	COMMA  <type>  <paradata>  <paralist> |  EMPTY

//函数声明和函数定义

<funtail>			->	<block> | SEMICOLON    

//函数体

<block>				->	LEFT_BRACE <subprogram> RIGHT_BRACE

### 程序

<subprogram>	->	<localdef> <subprogram> | <statement> <subprogram>  | EMPTY

//-----------------------------------------------------------------------------------局部变量定义
//局部变量定义和全局变量完全相同，但对全局变量初始化形式进行语义约束——只能初始化为字面量。
<localdef>		->	<type><defdata><deflist>
//-----------------------------------------------------------------------------------控制语句定义
//语句支持：赋值 while do-while for if-else return break continue switch

# <statement>		->	//赋值 空语句

# 									<altexpr>semicon

# 									//循环

# 									|<whilestat>|<forstat>|<dowhilestat>

​									//分支

# 									|<ifstat>|<switchstat>

​									//break;

# 									|  BREAK semicon

​									//continue;

# 									| CONTINE semicon

​									//return; return 1;

# 									| RETURN <altexpr>semicon

//while(){}
<whilestat>		->	rsv_while lparen<altexpr>rparen<block>
//do{}while();
<dowhilestat> -> 	rsv_do <block> rsv_while lparen<altexpr>rparen semicon
//for(int i=0,j=i;i<100;i++){}
<forstat> 		-> 	rsv_for lparen <forinit> semicon <altexpr> semicon <altexpr> rparen <block>
<forinit> 		->  <localdef> | <altexpr>
//if(a>b){}	if(a>b){}else{}
<ifstat>			->	rsv_if lparen<expr>rparen<block><elsestat>
<elsestat>		-> 	rsv_else<block>|^
//switch(a+b){case 1: case 'a': default:}
<switchstat>	-> 	rsv_switch lparen <expr> rparen lbrac <casestat> rbrac
<casestat> 		-> 	rsv_case <caselabel> colon <subprogram><casestat>
									|rsv_default colon <subprogram>
<caselabel>		->	<literal>
////-----------------------------------------------------------------------------------表达式语法
//表达式支持运算：= || && > < >= <= == != + - * / % ! - & * [] ()
<altexpr>			->	<expr>|^
<expr> 				-> 	<assexpr>
<assexpr>			->	<orexpr><asstail>
<asstail>			->	assign<assexpr>|^
//a||b
<orexpr> 			-> 	<andexpr><ortail>
<ortail> 			-> 	or <andexpr> <ortail>|^
//a&&b
<andexpr> 		-> 	<cmpexpr><andtail>
<andtail> 		-> 	and <cmpexpr> <andtail>|^
//a>b a>=b a<b a<=b a==b a!=b
<cmpexpr>			->	<aloexpr><cmptail>
<cmptail>			->	<cmps><aloexpr><cmptail>|^
<cmps>				->	gt|ge|ls|le|equ|nequ
//a+b a-b
<aloexpr>			->	<item><alotail>
<alotail>			->	<adds><item><alotail>|^
<adds>				->	add|sub
//a*b a/b a%b
<item>				->	<factor><itemtail>
<itemtail>		->	<muls><factor><itemtail>|^
<muls>				->	mul|div|mod
//!a -a &a *a ++a --a
<factor> 			-> 	<lop><factor>|<val>
<lop> 				-> 	not|sub|lea|mul|incr|decr
//i++ i--
<val>					->	<elem><rop>
<rop>					->	incr|decr
//a- (a+b)*c 100 "abc" 'A'
<elem>				->	ident<idexpr>|lparen<expr>rparen|<literal>
//字面量
<literal>			->	number|string|chara
//a a[i] a(i)
<idexpr>			->	lbrack <expr> rbrack|lparen<realarg>rparen|^
//fun(i=1,a[i],"123")
<realarg>			->	<arg><arglist>|^
<arglist>			->	comma<arg><arglist>|^
<arg> 				-> 	<expr>