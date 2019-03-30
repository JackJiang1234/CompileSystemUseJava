# CompileSystemUseJava

## 导论

## 词法分析

### 词法单元

#### 关键字
 int, char, void, if, else, switch, case, default, while, do, for, break, continue, return
 
 #### 分界符
 ,, ;, {, }
 #### 运算符
 *, /, %, ++, --, !, !=, &, &&, ||, >, >=, <, <=, =, ==, (, ), [,]
 
 #### 常量
 字符串, 数字, 字符
 
 ####　注释
 //,  /* */

### 理论
有限状态机与无限状态机理论

基于有限状态机

## 语法分析
语法表示  BNF, EBNF

语言语法列表  


解析语法算法LL(1)  消除左递归和公因子   SELECT,FOLLOW,FIRST集合  
对语法建模

同构树 所有结点都是同一类型  只关心叶子结点

异型树 每个结点有特点类型， 按语法规则建模，利用静态类型系统设计结点

Antlr   Lex,YACC 开源版本Flex和Bison

生成语法树

通过语法树记录状态记录 符号表(变量，函数, 常量)
语法树怎么进行语义检查?
语法树怎么转换为中间代码?

## 语义分析

生成中间代码

生成汇编代码

## 汇编


## 链接

## 参考
[javascript语法树](https://astexplorer.net/)  
[csharpsyntaxtree](https://docs.microsoft.com/en-us/dotnet/api/microsoft.codeanalysis.csharp.csharpsyntaxtree?view=roslyn-dotnet)  
[antrl4测试语法树](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md)
[使用 Antlr 开发领域语言](https://www.ibm.com/developerworks/cn/java/j-lo-antlr/index.html)

书  
antlr4权威指南