package com.zhukai.spring.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:application-demo1.xml");

        System.out.println("context 启动成功");

        MessageService messageService = context.getBean(MessageService.class);

        System.out.println(messageService.getMessage());

    }
}
