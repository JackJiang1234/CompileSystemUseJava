package com.compile.lexical;

import java.io.*;
import java.util.Objects;

/**
 *  represents source file scanner
 *
 * @author jack
 * @date 2019/03/12
 * */
public class SourceFileScanner implements Scanner {
    private InputStreamReader fileReader;
    private int readChar;

    public SourceFileScanner(String name) throws FileNotFoundException {
        this(new FileInputStream(name));
    }

    public SourceFileScanner(InputStream inputStream){
        this.fileReader = new InputStreamReader(inputStream);
    }

    @Override
    public boolean hasNext() {
        try {
            return (this.readChar = this.fileReader.read()) != -1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public char next() {
        return (char) this.readChar;
    }

    @Override
    public void close() throws Exception {
        this.fileReader.close();
    }
}
