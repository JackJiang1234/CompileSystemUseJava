package com.toyc.lexical;

import com.toyc.lexical.token.BaseToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValveContext {
    private ParsePipeline pipeline;
    private Scanner scanner;
    private List<BaseValve> valves;
    private BaseToken token;
    private int index;

    public ValveContext(ParsePipeline pipeline) {
        this.scanner = pipeline.getScanner();
        this.pipeline = pipeline;
        this.valves = new ArrayList<>(Arrays.asList(pipeline.getValves()));
        this.valves.add(this.pipeline.getBasic());
        this.index = -1;
    }

    public Scanner getScanner() {
        return this.scanner;
    }

    public void setToken(BaseToken t) {
        this.token = t;
    }

    public BaseToken getToken() {
        return this.token;
    }

    public void invokeNext() {
        this.index++;
        if (this.index < this.valves.size()){
            this.valves.get(this.index).invoke(this);
        }
    }
}
