package com.zhukai.pattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ZiRuProxy implements InvocationHandler {

    // 声明委托人,最终要通过反射调用该委托人的相应方法
    private Person target;


    /**
     * 通过委托对象获得动态代理对象
     * @param target
     * @return
     */
    public Object getInstance(Person target) {

        this.target = target;

        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return o;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("自如管家帮您找房,请问您对房屋有什么要求?");

        // 通过反射调用target中对应的方法
        method.invoke(this.target, args);

        System.out.println("恭喜您,以后合适的房源,稍后将以手机短信的方式发送给您,请注意查收!");
        return null;
    }
}
