package com.toyc.lexical;

import com.toyc.lexical.token.BaseToken;

import java.io.InputStream;

public class LexerImpl implements Lexer {
    public LexerImpl(BaseScanner scanner) {
        this.scanner = scanner;
        this.preparePipeline();
    }

    @Override
    public BaseToken next() {
        return this.pipeline.invokeParse();
    }

    @Override
    public void close() throws Exception {
        this.scanner.close();
    }

    private void preparePipeline() {
        this.pipeline = new ParsePipeline(this.scanner);
        this.pipeline.setBasic(new EndValve());
        this.pipeline.addValve(new SkipWhiteSpaceValve());
        this.pipeline.addValve(new ParseIdentifierValve());
        this.pipeline.addValve(new ParseOperatorValve());
        this.pipeline.addValve(new ParseStringValve());
        this.pipeline.addValve(new ParsesNumberValve());
        this.pipeline.addValve(new ParseCharValve());
    }

    private BaseScanner scanner;
    private ParsePipeline pipeline;
}
