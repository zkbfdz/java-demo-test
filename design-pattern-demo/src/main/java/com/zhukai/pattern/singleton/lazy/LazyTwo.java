package com.zhukai.pattern.singleton.lazy;

/**
 * 内部类创建对象(线程安全)
 */
public class LazyTwo {

    // 私有化构造
    private LazyTwo() {}

    // 创建静态内部类
    private static final class LasyInnerClass {
        private static final LazyTwo INSTANCE =  new LazyTwo();
    }


    // 提供外部调用
    public static LazyTwo getInstance () {
        return LasyInnerClass.INSTANCE;
    }
}
