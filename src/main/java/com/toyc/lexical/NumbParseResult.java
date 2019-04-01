package com.toyc.lexical;

/**
 * @ClassName:
 * @Description 解析数字结果
 * @Author jianyong.jiang
 * @Date 2019/3/21 17:25
 * @Version 1.0.0
 */
class NumbParseResult {
    private String numStr;

    private int value;

    public String getNumStr() {
        return numStr;
    }

    public int getValue() {
        return value;
    }

    public NumbParseResult(String numStr, int value) {
        this.numStr = numStr;
        this.value = value;
    }
}
