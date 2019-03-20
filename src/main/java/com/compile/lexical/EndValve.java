package com.compile.lexical;

import com.compile.lexical.token.EndToken;

/**
 * @ClassName: EndValve
 * @Description 最后的parse处理, 正常情况下应该是已经到文件结尾，如果仍有其它字符，说明有不能处理的字符，其它抛出异常
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public class EndValve extends BaseValve {

    public final static String EXCEPTON_MESSAGE = "the string \"%s\" can not parse.";

    @Override
    public void invoke(ValveContext context) {
        Scanner scanner = context.getScanner();
        int readChar = scanner.next();

        if (readChar == BaseScanner.EOF) {
            context.setToken(EndToken.END);
        } else {
            CharAppender appender = new CharAppender();
            appender.append(readChar);

            while((readChar = scanner.next()) != BaseScanner.EOF){
                appender.append(readChar);
            }

            throw new LexicalParseException(String.format(EXCEPTON_MESSAGE, appender.toString()));
        }
    }
}
