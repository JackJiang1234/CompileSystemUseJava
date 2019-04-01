package com.toyc.lexical;

import com.toyc.lexical.token.BaseToken;
import com.toyc.lexical.token.CharToken;

/**
 * 解析单个字符, 规则'有效字符'
 * 支持的转义字符有\n, \\, \t, \0, \'
 *
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParseCharValve extends LookAheadCharBaseValue {
    @Override
    protected boolean isMatch(int ch) {
        return ch == '\'';
    }

    @Override
    protected BaseToken doParse(Scanner scanner) {
        int ch = scanner.next();
        char result;

        // 转义
        if (ch == '\\') {
            result = parseEscapeChar(scanner);
        } else if (ch == '\r' || ch == '\n' || ch == BaseScanner.EOF) {
            throw new LexicalParseException("char not closed quotation.");
        } else if (ch == '\'') {
            throw new LexicalParseException("char no data");
        } else {
            result = (char) ch;
        }
        ch = scanner.next();
        if (ch != '\''){ // 读掉右侧引号
            throw new LexicalParseException("error char format");
        }
        return new CharToken(result);
    }
}
