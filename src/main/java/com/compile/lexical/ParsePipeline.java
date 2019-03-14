package com.compile.lexical;

import com.compile.lexical.token.Token;

import java.util.Optional;

/**
 * base sanner for lexical analysis
 *
 * @author jianyong.jiang
 * @date 2019/03/14
 */
public class ParsePipeline {

    public BaseValve getBasic(){
        return  null;
    }

    public void setBasic(){

    }

    public void addValve(BaseValve ... valves){

    }

    public BaseValve[] getValves(){
        return null;
    }

    public Optional<Token> invokeParse(Scanner scanner){
        return null;
    }
}
