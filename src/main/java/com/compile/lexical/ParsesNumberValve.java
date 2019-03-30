package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.NumToken;

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
public class ParsesNumberValve extends LookAheadCharBaseValue {
    @Override
    protected boolean isMatch(int ch) {
        this.lookAhead = ch;
        return Character.isDigit(ch);
    }

    @Override
    protected BaseToken doParse(Scanner scanner) {
        scanner.pushBack(this.lookAhead);
        ParseNumberImpl impl = new ParseNumberImpl(scanner);
        NumbParseResult result = impl.parseNumber();
        return new NumToken(result.getNumStr(), result.getValue());
    }

    private int lookAhead;

}
