package com.zhukai.pattern.proxy.staticDemo;

/**
 * 代理类:自如平台
 */
public class ZiRu {

    // 定义房客
    private Customer customer;

    // 在构造方法中传入房客
    protected ZiRu(Customer customer){
        this.customer = customer;
    }

    // 代理房客的租房要求
    void rent() {
        System.out.println("自如管家帮您找房,请问您对房屋有什么要求?");
        customer.rentHouse();
        System.out.println("恭喜您,以后合适的房源,稍后将以手机短信的方式发送给您,请注意查收!");
    }
}
