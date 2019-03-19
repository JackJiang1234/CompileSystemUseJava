package com.compile.lexical;

import com.compile.lexical.token.BaseToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * base sanner for lexical analysis
 *
 * @author jianyong.jiang
 * @date 2019/03/14
 */
public class ParsePipeline {

    private BaseValve baseValve;
    private List<BaseValve> valves;

    public ParsePipeline() {
        this.valves = new ArrayList<>();
        this.baseValve = new ReportExceptionValve();
    }

    public BaseValve getBasic() {
        return this.baseValve;
    }

    public void setBasic(BaseValve basicValve) {
        this.baseValve = basicValve;
    }

    public void addValve(BaseValve... valves) {
        Collections.addAll(this.valves, valves);
    }

    public BaseValve[] getValves() {
        return this.valves.toArray(new BaseValve[this.valves.size()]);
    }

    public BaseToken invokeParse(Scanner scanner) {
        ValveContext context = new ValveContext(this, scanner);
        context.invokeNext();
        return context.getToken();
    }
}
