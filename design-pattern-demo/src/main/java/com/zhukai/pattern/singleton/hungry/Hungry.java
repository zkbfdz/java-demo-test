package com.zhukai.pattern.singleton.hungry;

/**
 * 饿汉式
 */
public class Hungry {

    // 私有化构造方法
    private Hungry() {}

    // 创建实例对象
    private static final Hungry hungry = new Hungry();

    // 提供外部调用
    public static Hungry getInstance() {
        return hungry;
    }

}
