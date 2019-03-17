package com.compile.lexical;

/**
 * 解析数字
 * 0x开头的十六制整数0x[0-9a-f]+
 * 0开头的八进制整数0[0-9]+
 * 十进制整数或浮点数 [0-9]+'.'?[0-9]+
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParsesNumberValve extends BaseValve {
    @Override
    public void invoke(ValveContext context) {

    }
}
