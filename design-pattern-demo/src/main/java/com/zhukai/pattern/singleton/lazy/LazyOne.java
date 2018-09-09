package com.zhukai.pattern.singleton.lazy;

/**
 * 传统懒汉(非线程安全)
 */
public class LazyOne {

    // 私有化构造
    private LazyOne() {}

    // 声明一个变量
    private static LazyOne lazyOne = null;

    // 提供外部调用
    public static LazyOne getInstance() {
        if (lazyOne == null) {
            lazyOne = new LazyOne();
        }
        return lazyOne;
    }

}
