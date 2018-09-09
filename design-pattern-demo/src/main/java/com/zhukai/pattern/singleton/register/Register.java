package com.zhukai.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Register {

    private Register(){}

    private static Map<String,Object> beanMap = new ConcurrentHashMap<>();

    public static Object getBean(String name) throws Exception {
        if (!beanMap.containsKey(name)) {
            beanMap.put(name,Class.forName(name).newInstance());
        }
        return beanMap.get(name);
    }
}
