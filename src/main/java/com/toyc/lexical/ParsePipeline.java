package com.toyc.lexical;

import com.toyc.lexical.token.BaseToken;

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
    private Scanner scanner;

    public ParsePipeline(Scanner scanner) {
        this.valves = new ArrayList<>();
        this.baseValve = new ReportExceptionValve();
        this.scanner = scanner;
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

    public Scanner getScanner() {
        return this.scanner;
    }

    public BaseValve[] getValves() {
        return this.valves.toArray(new BaseValve[this.valves.size()]);
    }

    public BaseToken invokeParse() {
        ValveContext context = new ValveContext(this);
        context.invokeNext();
        return context.getToken();
    }
}
