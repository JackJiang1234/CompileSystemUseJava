package com.compile.lexical;

import com.compile.lexical.token.BaseToken;
import com.compile.lexical.token.SeparatorToken;
import com.compile.lexical.token.SeparatorUtil;


/**
 * 解析分界符， , ; { }
 *
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParseSeparatorValve extends LookAheadCharBaseValue {

    @Override
    protected boolean isMatch(int ch) {
        this.lookAhead = ch;
        return SeparatorUtil.isSeparator(this.lookAhead);
    }

    @Override
    protected BaseToken doParse(Scanner scanner) {
        return new SeparatorToken((char) this.lookAhead);
    }

    private int lookAhead;
}
