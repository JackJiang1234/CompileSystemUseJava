package com.toyc.lexical;

import java.util.Objects;

/**
 * @author jianyong.jiang
 * @date 2019/03/12
 */
public class StringScanner extends BaseScanner {
    private String content;
    private int contentLength;
    private int readPosition;

    public String getContent() {
        return this.content;
    }

    public StringScanner(String content) {
        Objects.requireNonNull(content);
        this.content = content;
        this.contentLength = content.length();
        this.readPosition = -1;
    }

    @Override
    protected int subNext() {
        this.readPosition++;
        if (this.readPosition < this.contentLength) {
            return this.content.charAt(this.readPosition);
        }else {
            return EOF;
        }
    }
}
