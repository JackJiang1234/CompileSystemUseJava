package com.compile.lexical;

import com.compile.lexical.token.BaseToken;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LexerImpl implements Lexer {

    public LexerImpl(String fileName) throws FileNotFoundException {
        this(new FileInputStream(fileName));
    }

    public LexerImpl(InputStream stream) {
        this.sourceFileScanner = new SourceFileScanner(stream);
        this.preparePipeline();
    }

    @Override
    public BaseToken next() {
        return this.pipeline.invokeParse();
    }

    @Override
    public void close() throws Exception {
        this.sourceFileScanner.close();
    }

    private void preparePipeline(){
        this.pipeline = new ParsePipeline(this.sourceFileScanner);
        this.pipeline.setBasic(new EndValve());
        this.pipeline.addValve(new SkipWhiteSpaceValve());
        this.pipeline.addValve(new ParseIdentifierValve());
        this.pipeline.addValve(new ParseOperatorValve());
        this.pipeline.addValve(new ParseStringValve());
        this.pipeline.addValve(new ParsesNumberValve());
        this.pipeline.addValve(new ParseCharValve());
        this.pipeline.addValve(new ParseSeparatorValve());
    }

    private SourceFileScanner sourceFileScanner;
    private ParsePipeline pipeline;
}
