package com.compile.lexical;

/**
 * @ClassName: ParseNumberImpl
 * @Description 解析数字实现
 * @Author jianyong.jiang
 * @Date 2019/3/21 17:22
 * @Version 1.0.0
 */
 class ParseNumberImpl {

    private String numStr;
    private int line;
    private int col;

    public static final String PARSE_NUMBER_FORMAT_ERROR = "%d line %d column '%s' parse as %s num error.";

    public ParseNumberImpl(String numStr, int line, int col){
        this.numStr = numStr;
        this.line = line;
        this.col = col;
    }

    public NumbParseResult parseNumber(){
        Scanner scanner = new StringScanner(numStr);
        int readChar = scanner.next();
        if ('1' <= readChar && readChar <= '9') {
            // 十进制
            return this.parseDecimal(readChar, scanner);
        } else {
            // 八进制或十六进制
            return this.parseHexOrOct(readChar, scanner);
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

    private NumbParseResult parseHexOrOct(int readChar, Scanner scanner) {
        // 再读一个字符确认是八进制还是十六进制
        readChar = scanner.next();
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

        while (true){
            readChar = scanner.next();
            Integer number = ParseNumUtil.getHexNumberByChar(readChar);
            if (number == null) {
                if (appender.length() == 2){
                    // just 0x
                    throw new LexicalParseException(String.format(PARSE_NUMBER_FORMAT_ERROR, this.line, this.col, numStr, "hex"));
                }
                return new NumbParseResult(appender.toString(), value);
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

        while (true){
            readChar = scanner.next();
            if (Character.isDigit(readChar)) {
                Integer number = ParseNumUtil.getOctNumberByChar(readChar);
                if (number == null) {
                    // not octal number
                    throw new LexicalParseException(String.format(PARSE_NUMBER_FORMAT_ERROR, line, col, numStr, "octal"));
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
}
