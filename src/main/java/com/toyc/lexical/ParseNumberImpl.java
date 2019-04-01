package com.toyc.lexical;

/**
 * @ClassName: ParseNumberImpl
 * @Description 解析数字实现
 * @Author jianyong.jiang
 * @Date 2019/3/21
 * @Version 1.0.0
 */
class ParseNumberImpl {
    public static final String PARSE_NUMBER_FORMAT_ERROR = "%d line %d column parse as %s num error.";
    public static final String PARSE_NUMBER_HEX_ERROR = "%d line %d column behind 0x no data";

    public ParseNumberImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    public NumbParseResult parseNumber() {
        int next = scanner.next();
        if ('1' <= next && next <= '9') {
            // 十进制
            return this.parseDecimal(next, scanner);
        } else {
            // 八进制或十六进制
            return this.parseHexOrOct(scanner);
        }
    }

    private NumbParseResult parseDecimal(int readChar, Scanner scanner) {
        int value = ParseNumUtil.getDecimalNumberByChar(readChar);
        CharAppender appender = new CharAppender();
        appender.append(readChar);

        while (true) {
            readChar = scanner.next();
            if (Character.isDigit(readChar)) {
                appender.append(readChar);
                value = value * 10 + ParseNumUtil.getDecimalNumberByChar(readChar);
            } else {
                scanner.pushBack(readChar);
                break;
            }
        }

        return new NumbParseResult(appender.toString(), value);
    }

    private NumbParseResult parseHexOrOct(Scanner scanner) {
        // 再读一个字符确认是八进制还是十六进制
        int readChar = scanner.next();
        if (readChar == 'x') {
            // 十六进制
            return parseHex(scanner);
        } else {
            scanner.pushBack(readChar);
            return parseOct(scanner);
        }
    }

    private NumbParseResult parseHex(Scanner scanner) {
        int value = 0;
        int readChar;
        CharAppender appender = new CharAppender();
        appender.append('0').append('x');

        while (true) {
            readChar = scanner.next();
            Integer number = ParseNumUtil.getHexNumberByChar(readChar);
            if (number == null) {
                if (appender.length() == 2) {
                    // just 0x
                    throw new LexicalParseException(String.format(PARSE_NUMBER_HEX_ERROR, this.scanner.getLine(), this.scanner.getColumn()));
                } else {
                    scanner.pushBack(readChar);
                    return new NumbParseResult(appender.toString(), value);
                }
            } else {
                appender.append(readChar);
                value = value * 16 + number;
            }
        }
    }

    private NumbParseResult parseOct(Scanner scanner) {
        int value = 0;
        int readChar;
        CharAppender appender = new CharAppender();
        appender.append('0');

        while (true) {
            readChar = scanner.next();
            if (Character.isDigit(readChar)) {
                Integer number = ParseNumUtil.getOctNumberByChar(readChar);
                if (number == null) {
                    // not octal number
                    throw new LexicalParseException(String.format(PARSE_NUMBER_FORMAT_ERROR, this.scanner.getLine(), this.scanner.getColumn(), "octal"));
                } else {
                    appender.append(readChar);
                    value = value * 8 + number;
                }
            } else {
                scanner.pushBack(readChar);
                return new NumbParseResult(appender.toString(), value);
            }
        }
    }

    private Scanner scanner;
}
