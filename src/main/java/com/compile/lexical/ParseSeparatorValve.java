package com.compile.lexical;

import com.compile.lexical.token.SeparatorToken;
import com.compile.lexical.token.SeparatorUtil;


/**
 * 解析分界符， , ; { }
 *
 * @author jianyong.jiang
 * @date 2019/03/17
 */
public class ParseSeparatorValve extends BaseValve {
    @Override
    public void invoke(ValveContext context) {
        int ch = context.getScanner().next();
        if (SeparatorUtil.isSeparator(ch)) {
            SeparatorToken token = new SeparatorToken((char) ch);
            context.setToken(token);
        } else {
            context.getScanner().pushBack(ch);
            context.invokeNext();
        }
    }
}
