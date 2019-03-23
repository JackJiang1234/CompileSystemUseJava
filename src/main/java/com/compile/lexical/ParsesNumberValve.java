package com.compile.lexical;

import com.compile.lexical.token.NumToken;

import java.util.function.Supplier;

/**
 * 解析数字
 * 0x开头的十六制整数0x[0-9a-f]+
 * 0开头的八进制整数0[0-9]+
 * 十进制整数[1-9]+
 * todo 浮点数 [0-9]+'.'?[0-9]+
 * todo number lenght limit check
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
            scanner.pushBack(readChar);
            ParseNumberImpl impl = new ParseNumberImpl(this.readUntilWhitespace(scanner), scanner.getLine(), scanner.getColumn());
            NumbParseResult result = impl.parseNumber();
            context.setToken(new NumToken(result.getNumStr(), result.getValue()));
        } else {
            scanner.pushBack(readChar);
            context.invokeNext();
        }
    }
}
