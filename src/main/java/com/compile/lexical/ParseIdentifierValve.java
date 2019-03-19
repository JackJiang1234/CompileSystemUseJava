package com.compile.lexical;

import com.compile.lexical.token.BaseToken;

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
        char ch;

        while (scanner.hasNext()) {
            ch = scanner.next();
            if (isValidIdentifierStart(ch)) {

            } else {
                scanner.pushBack(ch);
                context.invokeNext();
                break;
            }
        }
    }

    private boolean isValidIdentifierStart(char c) {
        return Character.isAlphabetic(c) || c == '_';
    }

    private boolean isValidIdentifierChar(char c) {
        return this.isValidIdentifierStart(c) || Character.isDigit(c);
    }

    private BaseToken parse(char readChar, Scanner scanner) {
        StringBuilder idBuild = new StringBuilder();
        idBuild.append(readChar);

        while (scanner.hasNext()) {
            readChar = scanner.next();
            if (this.isValidIdentifierChar(readChar)) {
                idBuild.append(readChar);
            } else {
                scanner.pushBack(readChar);
                break;
            }
        }

        return this.createTokenById(idBuild.toString());
    }

    /**
     * 标识符有可能是关键字或普通的标识符
     */
    private BaseToken createTokenById(String id) {

        return null;
    }
}
