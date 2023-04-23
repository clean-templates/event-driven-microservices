package com.rolandsall.common.util;

import java.util.ArrayList;
import java.util.List;

public class CollectionsUtil {

    private static volatile CollectionsUtil INSTANCE;

    private CollectionsUtil() {
    }

    public static CollectionsUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (CollectionsUtil.class) {
                if (INSTANCE == null)
                    INSTANCE = new CollectionsUtil();
            }
        }
        return INSTANCE;
    }

    public <T> List<T> getListFromIterable(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

}