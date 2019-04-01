package com.toyc.common;

/**
 * @ClassName: ToycException
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public class ToycException extends RuntimeException {
    public ToycException() {
        super();
    }

    public ToycException(String message) {
        super(message);
    }

    public ToycException(String message, Throwable cause) {
        super(message, cause);
    }

    public ToycException(Throwable cause) {
        super(cause);
    }

    protected ToycException(String message, Throwable cause,
                            boolean enableSuppression,
                            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
