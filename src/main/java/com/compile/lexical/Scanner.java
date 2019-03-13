package com.compile.lexical;

import java.util.Objects;

/**
 * the sanner for lexical analysis
 * @author jianyong.jiang
 * @date 2019/03/12
 * */
public interface Scanner extends AutoCloseable {

    /**
     * push back a char then invoke next will return the char
     * */
    void pushBack(char c);

    /**
     * test has next char for then scanner
     * */
    boolean hasNext();

    /**
     * get next char
     * */
    char next();

    /**
     *
     * @author  jianyong.jiang
     * @date 2019/03/13
     * */
    abstract class BaseValve {

    }

    class ParseIdValve extends BaseValve {

    }

    /**
     * @author jianyong.jiang
     * @date 2019/03/13
     */
    class ParsePipeline {

        public BaseValve getBasic() {
            return null;
        }

        public void setBasic(BaseValve valve) {

        }

        public void addValve(BaseValve... valves) {

        }

        public BaseValve[] getValves() {
            return null;
        }

        public void invoke(Scanner scanner) {
            Objects.requireNonNull(scanner, "scanner");
        }
    }
}
