package com.toyc.lexical;

public class LexicalParseException extends RuntimeException {

    public LexicalParseException() {
        super();
    }

    public LexicalParseException(String message) {
        super(message);
    }

    public LexicalParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LexicalParseException(Throwable cause) {
        super(cause);
    }

    protected LexicalParseException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
