package com.zhukai.pattern.strategy;


public class Travel {

    public void Go(TransType type) {
        type.get().trans();
    }
}
