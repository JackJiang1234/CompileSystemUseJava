package com.toyc.lexical;

/**
 * @ClassName: 忽略空白符
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/3/20
 * @Version 1.0.0
 */
public class SkipWhiteSpaceValve extends BaseValve {

    @Override
    public void invoke(ValveContext context) {
        Scanner scanner = context.getScanner();
        int readChar;

        while (true) {
            readChar = scanner.next();
            if (!Character.isWhitespace(readChar)) {
                scanner.pushBack(readChar);
                break;
            }
        }
        context.invokeNext();
    }
}
