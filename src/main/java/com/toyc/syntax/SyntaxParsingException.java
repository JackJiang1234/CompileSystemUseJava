package com.toyc.syntax;

import com.toyc.common.ToycException;

/**
 * @ClassName: SyntaxParsingException
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class SyntaxParsingException extends ToycException {
    public SyntaxParsingException() {
        super();
    }

    public SyntaxParsingException(String message) {
        super(message);
    }

    public SyntaxParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SyntaxParsingException(Throwable cause) {
        super(cause);
    }

    protected SyntaxParsingException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
