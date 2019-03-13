package com.compile.lexical;

import sun.plugin.dom.exception.InvalidStateException;

import java.io.*;

/**
 * represents source file scanner
 *
 * @author jianyong.jiang
 * @date 2019/03/12
 */
public class SourceFileScanner extends BaseScanner {
    private InputStreamReader fileReader;
    private int readChar;

    public SourceFileScanner(String name) throws FileNotFoundException {
        this(new FileInputStream(name));
    }

    public SourceFileScanner(InputStream inputStream) {
        this.fileReader = new InputStreamReader(inputStream);
        this.readChar = -1;
    }

    @Override
    public void close() throws Exception {
        this.fileReader.close();
    }

    @Override
    protected boolean subHasNext() {
        try {
            return (this.readChar = this.fileReader.read()) != -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected char subNext() {
        if (this.readChar == -1) {
            throw new InvalidStateException("please invoke hasNext test method first.");
        } else {
            return (char) this.readChar;
        }
    }
}
