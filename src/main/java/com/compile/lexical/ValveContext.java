package com.compile.lexical;

import com.compile.lexical.token.Token;

public class ValveContext {

    private ParsePipeline pipeline;
    private Scanner scanner;
    private Token token;

    public ValveContext(ParsePipeline pipeline, Scanner scanner) {
        this.scanner = scanner;
        this.pipeline = pipeline;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void setToken(Token t) {
        this.token = t;
    }

    public Token getToken() {
        return this.token;
    }

    public void invokeNext() {
    }
}
