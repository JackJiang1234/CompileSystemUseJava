package com.toyc.inter;

/**
 * @Description 中间指令支持操作枚举
 * @Author jianyong.jiang
 * @Version 1.0.0
 */
public enum Op {
    //占位指令,默认值
    NOP,

    //声明指令 eg: DEC arg1 => (int/char */[]) arg1
    DEC,

    //函数入口和出口
    ENTRY,
    EXIT,

    //赋值运算 AS result,arg1 => result=arg1
    ASSIGN,

    //算数运算
    ADD, SUB, MUL, DIV, MOD,//加减乘除模
    NEG, //负 eg: NEG result,arg1 => result = -arg1

    //比较运算
    GT, GE, LT, LE, EQU, NE,//大小等 eg: GT result,arg1,arg2 => result=arg1 > arg2

    //逻辑运算
    NOT,//非 eg: NOT result,arg1 => result=!arg1
    AND, OR,//与或 eg: AND result,arg1,arg2 => result=arg1 && arg2

    //指针运算
    LEA,//取址 eg: LEA result,arg1 => result=&arg1
    SET,//设置左值 eg: SET result,arg1 => *arg1=result
    GET,//取右值 eg: GET result,arg1 => result=*arg1

    //跳转
    JMP,//无条件跳转 eg: JMP result => goto result
    JT,//真跳转	 eg: JT result,arg1 => if(arg1) goto result
    JF,//假跳转	 eg: JF result,arg1 => if(!arg1) goto result
    /*JG,JGE,JL,JLE,JE,*/JNE,//跳转 eg:JG result,arg1,arg2 => if(arg1 > arg2) goto result

    //函数调用
    ARG,//参数传递 eg: ARG arg1 => 传递参数arg1
    PROC,//调用过程 eg: PROC fun => 调用fun函数,fun()
    CALL,//调用函数 eg: CALL result,fun => 调用fun函数,返回值result=fun()
    RET,//直接返回 eg: RET => return
    RETV//带数据返回 eg:RET arg1 => return arg1
}
