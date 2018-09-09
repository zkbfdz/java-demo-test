package com.zhukai.pattern.proxy.cglib;

import com.zhukai.pattern.proxy.dynamic.Person;
import com.zhukai.pattern.proxy.staticDemo.ZiRu;
import sun.misc.ProxyGenerator;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        Customer customer = (Customer) new ZiRuProxy().getInstance(Customer.class);

        System.out.println(customer.getClass());

        byte [] bytes = ProxyGenerator.generateProxyClass(customer.getClass().getName(),new Class[]{Customer.class});
        FileOutputStream os = new FileOutputStream("E://Customer$$EnhancerByCGLIB$.class");
        os.write(bytes);
        os.close();

        customer.buyHouse();

        System.out.println("==================================");

        customer.rentHouse();

    }
}
