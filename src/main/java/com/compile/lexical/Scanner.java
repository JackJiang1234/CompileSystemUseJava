package com.compile.lexical;

/**
 * the sanner for lexical analysis
 * @author jianyong.jiang
 * @date 2019/03/12
 * */
public interface Scanner extends AutoCloseable {

    /**
     * push back a char then invoke next will return the char
     * */
    void pushBack(char c);

    /**
     * test has next char for then scanner
     * */
    boolean hasNext();

    /**
     * get next char
     * */
    char next();
}
