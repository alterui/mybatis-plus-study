package com.lr.web.util;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2020/4/3 2:04 下午
 */
public class Utils {

    public static <T, R> List<R> convertPOJOToVO(List<T> objectList, Class<R> className) {
        if (isEmptyList(objectList)) {
            return new ArrayList<>();
        }
        List<R> list = new ArrayList<R>();
        for (T object : objectList) {
            String data = JSON.toJSONString(object);
            R result = JSON.parseObject(data, className);
            list.add(result);
        }
        return list;
    }

    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }
}
