package com.zhukai.pattern.proxy.staticDemo;

public class Test {

    public static void main(String[] args) {
        Customer customer  = new Customer();
        ZiRu ziRu = new ZiRu(customer);
        ziRu.rent();
    }
}
