package com.toyc.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CollectionUtil
 * @Description TODO
 * @Author jianyong.jiang
 * @Date 2019/4/1
 * @Version 1.0.0
 */
public final class CollectionUtil {

    public static <T> List<T> createIfNull(List<T> list) {
        return list == null ? new ArrayList<>() : list;
    }
}
