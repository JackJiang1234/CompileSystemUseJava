package com.toyc.inter;

/**
 * @Description 中间指令支持操作枚举
 * @Author jianyong.jiang
 * @Version 1.0.0
 */
public enum Op {
    //占位指令,默认值
    NOP("nop"),

    LABEL(".L%s"),

    //声明指令 eg: DEC arg1 => (int/char */[]) arg1
    DEC("dec %s"),

    //函数入口和出口
    ENTRY("entry"),
    EXIT("exit"),

    //赋值运算 AS result,arg1 => result=arg1
    ASSIGN("%s = %s"),

    //算数运算
    ADD("%s = %s + %s"), SUB("%s = %s - %s"), MUL("%s = %s * %s"), DIV("%s = %s / %s"), MOD("%s = %s % %s"),//加减乘除模
    NEG("%s = -%s"), //负 eg: NEG result,arg1 => result = - arg1

    //比较运算
    //大小等 eg: GT result,arg1,arg2 => result=arg1 > arg2
    GT("%s = %s > %s"), GE("%s = %s >= %s"), LT("%s = %s < %s"), LE("%s = %s <= %s"), EQU("%s = %s == %s"), NE("%s = %s != %s"),

    //逻辑运算
    NOT("%s = !%s"),//非 eg: NOT result,arg1 => result=!arg1
    AND("%s = %s && %s"), OR("%s = %s || %s"),//与或 eg: AND result,arg1,arg2 => result=arg1 && arg2

    //指针运算
    LEA("%s = &%s"),//取址 eg: LEA result,arg1 => result=&arg1
    SET("*%s = %s"),//设置左值 eg: SET result,arg1 => *arg1=result
    GET("%s = *%s"),//取右值 eg: GET result,arg1 => result=*arg1

    //跳转
    JMP("goto %s"),//无条件跳转 eg: JMP result => goto result
    JT("if(%s) goto %s"),//真跳转	 eg: JT result,arg1 => if(arg1) goto result
    JF("if(!%s) goto %s"),//假跳转	 eg: JF result,arg1 => if(!arg1) goto result
    JNE("if(%s != %s) goto %s"),//跳转 eg:JNE result,arg1,arg2 => if(arg1 != arg2) goto result

    //函数调用
    ARG("arg %s"),//参数传递 eg: ARG arg1 => 传递参数arg1
    PROC("%s()"),//调用过程 eg: PROC fun => 函数调用,arg1()
    CALL("%s = %s()"),//调用函数 eg: CALL result,fun => 调用fun函数,返回值result=fun()
    RET("return goto %s"),//直接返回 eg: RET => return
    RETV("return %s goto %s");//带数据返回 eg:RET arg1 => return arg1

    Op(String instructionFormat){
        this.instructionFormat = instructionFormat;
    }

    /**
     * 表示指令生成格式
     * */
    public String getInstructionFormat(){
        return this.instructionFormat;
    }

    private String instructionFormat;
}
