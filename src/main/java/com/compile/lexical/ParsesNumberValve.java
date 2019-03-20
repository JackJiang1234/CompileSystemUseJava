package com.compile.lexical;

import com.compile.lexical.token.NumToken;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析数字
 * 0x开头的十六制整数0x[0-9a-f]+
 * 0开头的八进制整数0[0-9]+
 * 十进制整数[1-9]+
 * 浮点数 [0-9]+'.'?[0-9]+
 *
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParsesNumberValve extends BaseValve {
    public ParsesNumberValve() {
    }

    @Override
    public void invoke(ValveContext context) {
        Scanner scanner = context.getScanner();
        int readChar = scanner.next();
        if (Character.isDigit(readChar)) {
            CharAppender appender = new CharAppender();
            appender.append(readChar);

            while (true) {
                readChar = scanner.next();
                if (Character.isDigit(readChar)) {
                    appender.append(readChar);
                } else {
                    context.setToken(new NumToken(appender.toString()));
                    break;
                }
            }
        }else{
            scanner.pushBack(readChar);
            context.invokeNext();
        }
    }
}
