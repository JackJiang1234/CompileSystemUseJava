package com.toyc.lexical;

/**
 * the sanner for lexical analysis
 * @author jianyong.jiang
 * @date 2019/03/12
 * */
public interface Scanner extends AutoCloseable {

    /**
     * push back a char then invoke next will return the char
     * */
    void pushBack(int c);

    /**
    　* @description: read next char
    　* @return return -1 if read the end of file, otherwise return the read char
    　*/
    int next();

    /**
     * 当前行
     * */
    int getLine();

    /**
     * 当前列
     * */
    int getColumn();
}
