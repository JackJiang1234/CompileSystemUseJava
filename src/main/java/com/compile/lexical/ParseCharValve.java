package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.CharToken;

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
        } else if (ch == '\r' || ch == '\n' || ch == -1) {
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

    // 解析转义符
    private char parseEscapeChar(Scanner scanner) {
        int ch = scanner.next();
        char result;

        if (ch == 'n') {
            result = '\n';
        } else if (ch == '\\') {
            result = '\\';
        } else if (ch == 't') {
            result = '\t';
        } else if (ch == '0') {
            result = '\0';
        } else if (ch == '\'') {
            result = '\'';
        } else {
            throw new LexicalParseException(String.format("unknown escape char %c.", ch));
        }

        return result;
    }
}
