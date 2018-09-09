package com.zhukai.pattern.strategy.model;

public enum TransType {

    CAR(new Car()),
    PLANE(new Plane()),
    TRAIN(new Train());

    private Transport transport;

    TransType(Transport transport) {
        this.transport = transport;
    }

    public Transport get() {
        return this.transport;
    }
}
