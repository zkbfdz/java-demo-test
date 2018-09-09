package com.zhukai.pattern.strategy;


public class Test {

    public static void main(String[] args) {
        new Travel().Go(TransType.CAR);
        new Travel().Go(TransType.PLANE);
        new Travel().Go(TransType.TRAIN);
    }
}
