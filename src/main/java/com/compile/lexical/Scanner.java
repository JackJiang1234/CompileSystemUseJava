package com.compile.lexical;

/**
 * the sanner for lexical analysis
 * @author jack
 * @date 2019/03/12
 * */
public interface Scanner extends AutoCloseable {

    /**
     * com if has next
     * */
    boolean hasNext();

    /**
     * get next char
     * */
    char next();
}
