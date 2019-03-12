package com.compile.lexical;

import java.util.Objects;

/**
 *
 * @author jack
 * @date 2019/03/12
 * */
public class StringScanner implements Scanner {
    private String content;
    private int contentLength;
    private int readPosition;

    public String getContent(){
        return this.content;
    }

    public StringScanner(String content){
        Objects.requireNonNull(content);
        this.content = content;
        this.contentLength = content.length();
        this.readPosition = -1;
    }

    @Override
    public boolean hasNext() {
        this.readPosition++;
        return this.readPosition < this.contentLength;
    }

    @Override
    public char next() {
        return this.content.charAt(this.readPosition < this.contentLength ? this.readPosition : this.contentLength - 1);
    }

    @Override
    public void close() throws Exception {

    }
}
