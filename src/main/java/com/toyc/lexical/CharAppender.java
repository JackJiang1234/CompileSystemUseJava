package com.toyc.lexical;

/**
 * @ClassName: CharAppender
 * @Description 表示字符追加处理
 * @Author jianyong.jiang
 * @Date 2019/3/20 13:37
 * @Version 1.0.0
 */
public class CharAppender {
    private StringBuilder appender;

    public CharAppender() {
        this.appender = new StringBuilder();
    }

    public CharAppender(char... chars) {
        this();
        this.appender.append(chars);
    }

    public CharAppender(int... chars) {
        this();
        for (int ch : chars) {
            this.append((char) ch);
        }
    }

    public CharAppender append(int ch) {
        return this.append((char) ch);
    }

    public CharAppender append(char ch) {
        this.appender.append(ch);
        return this;
    }

    public int length() {
        return this.appender.length();
    }

    @Override
    public String toString() {
        return this.appender.toString();
    }
}
