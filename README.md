# CompileSystemUseJava

## 导论

## 词法分析

### 词法单元

#### 关键字
 int, char, void, if, else, switch, case, default, while, do, for, break, continue, return, extern

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
语法表示  BNF, EBNF  终结符和非终结符
格式 终结符 大写
非终结符  <小写字母>

语言语法列表  


解析语法算法LL(1)  消除左递归和公因子   SELECT,FOLLOW,FIRST集合  

同构树 所有结点都是同一类型  只关心叶子结点

异形不规则树 每个结点有特点类型， 按语法规则建模，利用静态类型系统设计结点
访问者模式

Antlr   Lex,YACC 开源版本Flex和Bison

生成语法树

通过语法树记录状态记录 符号表(变量，函数, 常量)
语法树怎么进行语义检查?
语法树怎么转换为中间代码?

#### 语法制导翻译

属性 + 语义规则 

树结点增加属性 综合属性与继承属性

结点N上的综合属性只能通过N的子结点和N本身的属性值来定义

结点N上的继承属性只能通过N的父结点，N本身和N的兄弟结点上的属性值来定义

依赖图描述了某个语法分析树中的属性实例之间的信息流

每一个SDD(语法制导定义 Syntax-Directed Definition)的每个属性都是综合属性，它就是S属性

L属性产生式体所关联的各个属性之间依赖总是从左到右

L属性翻译 -> 自顶向下

S属性翻译-> 自底向上

语义规则 : 访问某个结点执行特定的语义代码



## 语义分析

生成中间代码

生成汇编代码

## 汇编


## 链接

## 参考
[LL1](http://www.cs.ecu.edu/karl/5220/spr16-large/Notes/Top-down/LL1.html)
[javascript语法树](https://astexplorer.net/)  
[csharpsyntaxtree](https://docs.microsoft.com/en-us/dotnet/api/microsoft.codeanalysis.csharp.csharpsyntaxtree?view=roslyn-dotnet)  
[antrl4测试语法树](https://github.com/antlr/antlr4/blob/master/doc/getting-started.md)
[使用 Antlr 开发领域语言](https://www.ibm.com/developerworks/cn/java/j-lo-antlr/index.html)
[维基百科编译器词汇](https://en.wikipedia.org/wiki/Compiler)  

[人人都能读懂的编译器原理](<http://blog.jobbole.com/114466/>)

书  
antlr4权威指南