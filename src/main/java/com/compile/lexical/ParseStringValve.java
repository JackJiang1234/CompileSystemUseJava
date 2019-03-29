package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.StringToken;

/**
 * 解析字符串 双引号括起来0或多个字符  "[.]*"
 * 支持的转义字符有\n, \\, \t, \0, \'
 *
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParseStringValve extends LookAheadCharBaseValue {

    @Override
    protected boolean isMatch(int ch) {
        return ch == '"';
    }

    @Override
    protected BaseToken doParse(Scanner scanner) {
        CharAppender charAppender = new CharAppender();
        int ch;

        while ((ch = scanner.next()) != '"'){
            if (ch == '\\'){
                // 转义
                charAppender.append(this.parseEscapeChar(scanner));
            }else if (ch == '\n'|| ch == -1){
                throw new LexicalParseException("string not closed quotation.");
            }else {
                charAppender.append(ch);
            }
        }
        return new StringToken(charAppender.toString());
    }
}
