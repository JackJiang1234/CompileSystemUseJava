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


    protected String readUntilNewLine(Scanner scanner){
        return readUntilNotMatch(scanner, readChar -> !(readChar == '\r' || readChar == '\n'));
    }

    protected String readUntilNotMatch(Scanner scanner, Function<Integer, Boolean> match) {
        CharAppender appender = new CharAppender();
        int readChar;

        while ((readChar = scanner.next()) != BaseScanner.EOF) {
            if (!match.apply(readChar)) {
                scanner.pushBack(readChar);
                break;
            } else {
                appender.append(readChar);
            }
        }

        return appender.toString();
    }
}
