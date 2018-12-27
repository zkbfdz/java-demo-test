package com.zhukai.practise.factoryInjection;

public class Foo {

    private BarInterface barInterface;

    public Foo() {
        barInterface = BarInterfaceFactory.getInstance();
    }

    public BarInterface getBarInterface() {
        return barInterface;
    }

    public void setBarInterface(BarInterface barInterface) {
        this.barInterface = barInterface;
    }
}
