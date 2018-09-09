package com.zhukai.pattern.singleton.serialize;

import java.io.Serializable;

public class SerializePojo implements Serializable {

    private static final SerializePojo INSTANCE = new SerializePojo();

    private SerializePojo(){}

    public static SerializePojo getInstance() {
        return INSTANCE;
    }

    // 该方法为底层调用,不重写在反序列化时会new一个新的对象,这里重写改方法,将单例中的对象返回,
    // 保证序列化前后对象为同一个对象
    private static  Object getInstace(){
        return  INSTANCE;
    }


}
