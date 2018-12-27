package com.zhukai.practise.factoryInjection;

public class BarInterfaceImpl implements BarInterface {

    private FooBar fooBar;

    public BarInterfaceImpl(){}

    public BarInterfaceImpl(FooBar fooBar) {
        this.fooBar = fooBar;
    }
}
