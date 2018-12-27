package com.zhukai.practise.factoryInjection;

public class BarInterfaceFactory {

    public static BarInterface getInstance() {
        return new BarInterfaceImpl();
    }

    public static BarInterface getInstance(FooBar fooBar) {
        return new BarInterfaceImpl(fooBar);
    }
}
