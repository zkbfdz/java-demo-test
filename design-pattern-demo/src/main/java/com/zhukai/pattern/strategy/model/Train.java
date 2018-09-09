package com.zhukai.pattern.strategy.model;

public class Train implements Transport {
    @Override
    public void trans() {
        System.out.println("坐火车");
    }
}
