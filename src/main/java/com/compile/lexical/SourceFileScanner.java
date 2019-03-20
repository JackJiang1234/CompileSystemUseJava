package com.compile.lexical;

import java.io.*;
/**
 * represents source file scanner
 *
 * @author jianyong.jiang
 * @date 2019/03/12
 */
public class SourceFileScanner extends BaseScanner {
    private InputStreamReader fileReader;

    public SourceFileScanner(String name) throws FileNotFoundException {
        this(new FileInputStream(name));
    }

    public SourceFileScanner(InputStream inputStream) {
        this.fileReader = new InputStreamReader(inputStream);
    }

    @Override
    public void close() throws Exception {
        this.fileReader.close();
    }

    @Override
    protected int subNext() {
        try {
            return this.fileReader.read();
        } catch (IOException e) {
            throw new LexicalParseException("read source file raise error.", e);
        }
    }
}
