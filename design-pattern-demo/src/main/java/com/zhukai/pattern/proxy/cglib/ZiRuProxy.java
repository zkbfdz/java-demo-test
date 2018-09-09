package com.zhukai.pattern.proxy.cglib;

import com.sun.corba.se.spi.ior.ObjectKey;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 代理类
 */
public class ZiRuProxy implements MethodInterceptor {

    /**
     * 生成代理对象
     * @param clazz 委托类
     * @return
     */
    Object getInstance(Class<?> clazz) {

        Enhancer enhancer = new Enhancer();

        // 设置代理对象的父类为委托类
        enhancer.setSuperclass(clazz);

        // 设置执行的代理类对象
        enhancer.setCallback(this);

        return enhancer.create();

    }

    /**
     * 需要增强的逻辑
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("自如管家帮您找房,请问您对房屋有什么要求?");

        // 通过代理类的方法得到父类(委托类)方法并执行
        methodProxy.invokeSuper(o, objects);

        System.out.println("恭喜您,以后合适的房源,稍后将以手机短信的方式发送给您,请注意查收!");

        return null;
    }
}
