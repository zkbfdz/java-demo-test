package com.zhukai.pattern.proxy.dynamic;

public class Customer implements Person {

    Customer(){}

    public void rentHouse() {
        System.out.println("我想租房,要求面积为100平米.");
    }

    public void buyHouse() {
        System.out.println("我想买房,要求房价在100万左右.");
    }
}
