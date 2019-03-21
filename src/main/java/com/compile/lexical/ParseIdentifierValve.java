package com.compile.lexical;

import com.compile.lexical.token.*;

/**
 * 解析标识符， 通常是方法名，变量名或关键字，只允许以字符a-z,A-Z和_开头，后面接a-z, A-Z, _和数字
 * 正则表达式[a-zA-Z_]+[a-zA-Z_0-9]*
 *
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParseIdentifierValve extends BaseValve {

    @Override
    public void invoke(ValveContext context) {
        Scanner scanner = context.getScanner();
        int ch;

        ch = scanner.next();
        if (isValidIdentifierStart(ch)) {
            context.setToken(parse(ch, context.getScanner()));
        } else {
            scanner.pushBack(ch);
            context.invokeNext();
        }
    }

    private boolean isValidIdentifierStart(int c) {
        return Character.isAlphabetic(c) || c == '_';
    }

    private boolean isValidIdentifierChar(int c) {
        return this.isValidIdentifierStart(c) || Character.isDigit(c);
    }

    private BaseToken parse(int readChar, Scanner scanner) {
        CharAppender appender = new CharAppender();
        appender.append(readChar);
        // todo id length limit check
        while (true) {
            readChar = scanner.next();
            if (this.isValidIdentifierChar(readChar)) {
                appender.append(readChar);
            } else {
                scanner.pushBack(readChar);
                break;
            }
        }

        return this.createTokenById(appender.toString());
    }

    /**
     * 标识符有可能是关键字或普通的标识符
     */
    private BaseToken createTokenById(String id) {
        KeywordEnum keywordEnum = KeywordUtils.getKeywordEnumByName(id);
        return keywordEnum == null ? new IdentifierToken(id) : new KeywordToken(keywordEnum);
    }
}
