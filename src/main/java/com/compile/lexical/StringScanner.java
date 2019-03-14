package com.compile.lexical;

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
    protected boolean subHasNext() {
        return (this.readPosition + 1) < this.contentLength;
    }

    @Override
    protected char subNext() {
        this.readPosition++;
        this.readPosition  = this.readPosition < this.contentLength ? readPosition : this.contentLength - 1;
        return this.content.charAt(this.readPosition);
    }

    @Override
    public void close() throws Exception {

    }
}
