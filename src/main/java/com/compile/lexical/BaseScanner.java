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
    private Queue<Integer> pushBackQueue;

    public final static int EOF = -1;

    public BaseScanner() {
        pushBackQueue = new ArrayDeque<>();
        this.line = 0;
        this.col = 0;
    }

    @Override
    public void pushBack(int c){
        this.pushBackQueue.add(c);
        this.col--;
    }

    @Override
    public int next() {
        int ret;
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
        return this.line;
    }

    @Override
    public int getColumn() {
        return this.col;
    }

    @Override
    public void close() throws Exception {

    }

    protected abstract int subNext();
}
