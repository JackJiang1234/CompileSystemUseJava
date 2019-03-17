package com.compile.lexical;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * base sanner for lexical analysis
 *
 * @author jianyong.jiang
 * @date 2019/03/13
 */
public abstract class BaseScanner implements Scanner {

    private int line;
    private int col;
    private Queue<Character> pushBackQueue;
    private final static String newLine = System.getProperty("line.separator");

    public BaseScanner() {
        pushBackQueue = new ArrayDeque<>();
        this.line = 0;
        this.col = 0;
    }

    @Override
    public void pushBack(char c){
        this.pushBackQueue.add(c);
        this.col--;
    }

    @Override
    public boolean hasNext() {
        return this.pushBackQueue.size() > 0 || subHasNext();
    }

    @Override
    public char next() {
        char ret;
        if (this.pushBackQueue.size() > 0) {
            ret = this.pushBackQueue.remove();
        } else {
            ret = subNext();
        }

        if (ret == '\r'){
            this.line++;
            this.col = 0;
        }else{
            this.col++;
        }
        return ret;
    }

    @Override
    public int getLine() {
        return 0;
    }

    @Override
    public int getColumn() {
        return this.col;
    }

    protected abstract boolean subHasNext();

    protected abstract char subNext();
}
