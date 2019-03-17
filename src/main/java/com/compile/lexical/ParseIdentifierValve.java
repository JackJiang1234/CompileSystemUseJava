package com.compile.lexical;

/**
 * 解析标识符， 通常是方法名，变量名或关键字，只允许以字符a-z,A-Z和_开头，后面接a-z, A-Z, _和数字
 * 正则表达式[a-zA-Z_]+[a-zA-Z_0-9]*
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParseIdentifierValve extends BaseValve {

    @Override
    public void invoke(ValveContext context) {

    }
}
