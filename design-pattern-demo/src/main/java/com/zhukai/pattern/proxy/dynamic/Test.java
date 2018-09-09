package com.zhukai.pattern.proxy.dynamic;


public class Test {
    public static void main(String[] args) {

        Person target = new Customer();

        // 得到代理对象
        Person proxy = (Person) new ZiRuProxy().getInstance(target);

        System.out.println(proxy.getClass());

        proxy.buyHouse();

        System.out.println("================================");

        proxy.rentHouse();
    }
}
