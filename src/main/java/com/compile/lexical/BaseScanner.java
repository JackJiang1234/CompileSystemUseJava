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

    private Queue<Character> pushBackQueue;

    public BaseScanner() {
        pushBackQueue = new ArrayDeque<>();
    }

    @Override
    public void pushBack(char c){
        this.pushBackQueue.add(c);
    }

    @Override
    public boolean hasNext() {
        return this.pushBackQueue.size() > 0 || subHasNext();
    }

    @Override
    public char next() {
        if (this.pushBackQueue.size() > 0) {
            return this.pushBackQueue.remove();
        } else {
            return subNext();
        }
    }

    protected abstract boolean subHasNext();

    protected abstract char subNext();
}
