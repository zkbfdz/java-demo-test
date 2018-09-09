package com.zhukai.pattern.strategy.model;

public class Plane implements Transport{
    @Override
    public void trans() {
        System.out.println("坐飞机");
    }
}
