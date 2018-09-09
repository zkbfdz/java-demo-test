package com.zhukai.pattern.strategy.model;

public class Car implements Transport {
    @Override
    public void trans() {
        System.out.println("开车");
    }
}
