package com.compile.lexical;

/**
 * base Valve for lexical analysis
 *
 * @author jianyong.jiang
 * @date 2019/03/14
 */
public abstract class BaseValve {
    public String getInfo() {
        return this.getClass().getName();
    }
    public abstract void invoke(ValveContext context);
}
