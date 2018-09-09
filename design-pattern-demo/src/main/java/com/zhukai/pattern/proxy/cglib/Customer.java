package com.zhukai.pattern.proxy.cglib;

import com.zhukai.pattern.proxy.dynamic.Person;

/**
 * 委托类
 */
public class Customer {

    Customer(){}

    public void rentHouse() {
        System.out.println("我想租房,要求面积为100平米.");
    }

    public void buyHouse() {
        System.out.println("我想买房,要求房价在100万左右.");
    }
}
