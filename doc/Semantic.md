# 语义规则

### 约定

终结符用大写字母，∈表示空

 非终结符用<小写>

### TOYC程序文法
<program>			->	<segment> <program> |  ∈

### 程序由变量定义，变量声明，函数定义，函数声明组成

<segment>			->	 <type> <defcontent> 

### 基本类型

<type>				->	INT ｜ CHAR  |  VOID

### 指针定义或 非指针定义

//  *p=null, a=100, a[10] = 1    |  a = 100

<defcontent>	->	MUL ID <init> <deflist>  | ID  <idtail>

### 初始化值 或 空  如 = 表达式求值
<init>				->	ASSIGN <expr> |  ∈

### 多变量定义  
 <deflist>			->	COMMA <defdata> <deflist> | SEMICOLON    

// *p=null,a=100,a[10]  指针，变量，数组定义序列

<defdata>			->	ID <var_or_array_init> | MUL ID  <init> 

### 基本定义语法

//a=100,a[10]=1 变量 数组 初始化

<var_or_array_init>			->	LEFT_BRACKET NUM  RIGHT_BRACKET |  <init>

//a a[10] 变量和数组定义，其他（函数声明和函数定义）

<idtail>			->	<var_or_array_init> <deflist> | LEFT_PARENTHESE <para> RIGHT_PARENTHESE <funtail>

### 函数声明或定义语法

//函数参数列表

<para>				->	<type> <paradata> <paralist> | ∈

<paradata>		->	MUL ID  |  ID  <paraarray>

<paraarray>->	LEFT_BRACKET   NUMBER   RIGHT_BRACKET  |  ∈

<paralist>		->	COMMA  <type>  <paradata>  <paralist> |  ∈

// 函数声明和函数定义

<funtail>			->	<block> | SEMICOLON    

// 语句块 

<block>				->	LEFT_BRACE <sequence> RIGHT_BRACE

### 程序

<sequence>	->	<localdef> <sequence> | <statement> <sequence>  | ∈

#### 局部变量定义

// 局部变量定义和全局变量完全相同，但对全局变量初始化形式进行语义约束——只能初始化为字面量。
<localdef>		->  <type><defdata><deflist>

//-----------------------------------------------------------------------------------控制语句定义

#### 语句：赋值 while do-while for if-else return break continue switch

```java
<statement>  ->	

// 赋值 空语句

<altexpr> SEMICOLON    

// 循环

|<whilestat>|<forstat>|<dowhilestat>

// 分支

|<ifstat>|<switchstat>

// break;

|  BREAK SEMICOLON    

// continue;

| CONTINE SEMICOLON    

// return; return 1;

| RETURN <altexpr> SEMICOLON    
```

// while(){}

<whilestat>		->  WHILE  LEFT_PARENTHESE  <altexpr> RIGHT_PARENTHESE <block>

// do{}while();
<dowhilestat> -> 	DO <block> WHILE LEFT_PARENTHESE  <altexpr> RIGHT_PARENTHESE  SEMICOLON

// for(int i=0,j=i;i<100;i++){}
<forstat> 		-> 	FOR LEFT_PARENTHESE  <forinit> SEMICOLON <altexpr> SEMICOLON <altexpr> RIGHT_PARENTHESE <block>
<forinit> 		->  <localdef> | <altexpr>

// if(a>b){}	if(a>b){}else{}
<ifstat>			->  IF LEFT_PARENTHESE  <expr> RIGHT_PARENTHESE  <block> <elsestat>
<elsestat>		-> 	ELSE <block> | ∈

// switch(a+b){case 1: case 'a': default:}
<switchstat>	-> 	SWITCH  LEFT_PARENTHESE  <expr> RIGHT_PARENTHESE  LEFT_BRACE <casestat> RIGHT_BRACE
<casestat> 		->     CASE <caselabel> COLON <subprogram><casestat> | DEFAULT COLON 
<caselabel>		->   <literal>

#### // 表达式语法

// 表达式支持运算：= || && > < >= <= == != + - * / % ! - & * [] ()
<altexpr>	->   <expr> |  ∈
<expr> 	     ->    <assexpr>
<assexpr>	->   <orexpr> <asstail>
<asstail>	->   ASSIGN <assexpr>| ∈

// a || b
<orexpr> 	 ->  <andexpr> <ortail>
<ortail> 	 ->  OR <andexpr> <ortail> | ∈

// a && b
<andexpr>       ->   <cmpexpr> <andtail>
<andtail>       ->  AND  <cmpexpr> <andtail> | ∈

//a>b a>=b a<b a<=b a==b a!=b
<cmpexpr>       ->  <aloexpr><cmptail>
<cmptail>       ->  <cmps> <aloexpr> <cmptail> | ∈
<cmps>	     ->  GT |  GTE |  LT |  LTE | EQU | NOT_EQU

// a+b a-b
<aloexpr>     ->  <item> <alotail>
<alotail>     ->   <adds> <item> <alotail> | ∈
<adds>	   ->    PLUS | MINUS

// a*b a/b a%b
<item>	       ->   <factor> <itemtail>
<itemtail>       ->    <muls> <factor> <itemtail> | ∈
<muls>	      ->    MUL | DIV | MOD

// !a -a &a *a ++a --a
<factor> 	->   <lop> <factor>  | <val>
<lop> 	     ->     NOT | MINUS | LEA | MUL | INCR | DECR    

// i++ i--
<val>	     ->   <elem> <rop>
<rop>	    ->   INCR | DECR

// a- (a+b)*c 100 "abc" 'A'
<elem>	->   ID <idexpr> | LEFT_PARENTHESE  <expr> RIGHT_PARENTHESE  |  <literal>

// 字面量
<literal>  -> NUMBER | STRING | CHARACTER

// a a[i] a(i)
<idexpr>  ->  LEFT_BRACKET <expr> RIGHT_BRACKET  | LEFT_PARENTHESE  <realarg> RIGHT_PARENTHESE  | ∈

// fun(i=1,a[i],"123")
<realarg>	->   <arg> <arglist> |  ∈
<arglist>	->  COMMA <arg> <arglist> | ∈
<arg> 		->  <expr>