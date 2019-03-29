package com.compile.lexical;

import com.compile.lexical.token.BaseToken;

/**
 * @ClassName: LookAheadCharBaseValue
 * @Description 向前看一个字符分析 模板方法
 * @Author jianyong.jiang
 * @Date 2019/3/29 11:47
 * @Version 1.0.0
 */
public abstract class LookAheadCharBaseValue extends BaseValve {

    @Override
    public void invoke(ValveContext context) {
        Scanner scanner = context.getScanner();
        int ch;

        ch = scanner.next();
        if (this.isMatch(ch)) {
            context.setToken(this.doParse(scanner));
        } else {
            scanner.pushBack(ch);
            context.invokeNext();
        }
    }

    protected abstract boolean isMatch(int ch);

    protected abstract BaseToken doParse(Scanner scanner);
}
