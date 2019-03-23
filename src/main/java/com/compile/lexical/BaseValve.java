package com.compile.lexical;

/**
 * base Valve for lexical analysis
 *
 * @author jianyong.jiang
 * @date 2019/03/14
 */
public abstract class BaseValve {
    public String getInfo() {
        return this.getClass().getName();
    }

    public abstract void invoke(ValveContext context);

    protected String readUntilWhitespace(Scanner scanner) {
        CharAppender appender = new CharAppender();
        int readChar;

        while (true) {
            readChar = scanner.next();
            if (Character.isWhitespace(readChar) || readChar == BaseScanner.EOF) {
                scanner.pushBack(readChar);
                break;
            } else {
                appender.append(readChar);
            }
        }

        return appender.toString();
    }
}
