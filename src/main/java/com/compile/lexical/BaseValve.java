package com.compile.lexical;

import java.util.function.Function;

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
        return readUntilMatch(scanner, readChar -> Character.isWhitespace(readChar));
    }

    protected String readUntilNewLine(Scanner scanner){
        return readUntilMatch(scanner, readChar -> readChar == '\r' || readChar == '\n');
    }

    private String readUntilMatch(Scanner scanner, Function<Integer, Boolean> match) {
        CharAppender appender = new CharAppender();
        int readChar;

        while ((readChar = scanner.next()) != BaseScanner.EOF) {
            if (match.apply(readChar)) {
                scanner.pushBack(readChar);
                break;
            } else {
                appender.append(readChar);
            }
        }

        return appender.toString();
    }
}
