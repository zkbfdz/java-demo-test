package com.zhukai.practise.factoryInjection;

import com.zhukai.practise.factoryInjection.BarInterface;
import com.zhukai.practise.factoryInjection.BarInterfaceImpl;

public class NonStaticBarInterfaceFactory {

    public BarInterface getInstace() {
        return new BarInterfaceImpl();
    }
}
