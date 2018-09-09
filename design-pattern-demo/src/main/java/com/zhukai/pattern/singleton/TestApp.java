package com.zhukai.pattern.singleton;

import com.zhukai.pattern.singleton.hungry.Hungry;
import com.zhukai.pattern.singleton.lazy.LazyOne;
import com.zhukai.pattern.singleton.lazy.LazyTwo;
import com.zhukai.pattern.singleton.register.Pojo;
import com.zhukai.pattern.singleton.register.Register;
import com.zhukai.pattern.singleton.serialize.SerializePojo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.concurrent.CountDownLatch;

public class TestApp {

    private static final int threadNum = 200;

    private static final CountDownLatch latch = new CountDownLatch(threadNum);

    private Long beginTime = null;

    @Before
    public void init() {
        beginTime = System.currentTimeMillis();
    }

    @After
    public void after() {
        System.out.println(String.format("共花费%s毫秒", System.currentTimeMillis()-beginTime));
    }

    @Test
    public void hungry() throws InterruptedException {

        for (int i = 0; i < threadNum; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 所有线程先到此等待
                        latch.await();
                        // countDown之后的逻辑
                        Hungry hungry = Hungry.getInstance();
                        System.out.println(hungry);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            // 没每创建一个线程就countDown
            latch.countDown();
        }
    }

    @Test
    public void lazyOne() throws InterruptedException {
        for (int i = 0; i < threadNum; i++) {
            final int x = i;
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 所有线程先到此等待
                        latch.await();
                        // countDown之后的逻辑
                        LazyOne lazyOne = LazyOne.getInstance();
                        System.out.println(lazyOne + "---" + x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            // 没每创建一个线程就countDown
            latch.countDown();
        }
        Thread.sleep(1000);
    }

    @Test
    public void lazyTwo() throws InterruptedException {
        for (int i = 0; i < threadNum; i++) {
            final int x = i;
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 所有线程先到此等待
                        latch.await();
                        // countDown之后的逻辑
                        LazyTwo lazyTwo = LazyTwo.getInstance();
                        System.out.println(lazyTwo + "---" + x);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            // 没每创建一个线程就countDown
            latch.countDown();
        }
        Thread.sleep(1000);
    }

    @Test
    public void RegisterTest() throws InterruptedException {
        for (int i = 0; i < threadNum; i++) {
            final int x = i;
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 所有线程先到此等待
                        latch.await();
                        // countDown之后的逻辑
                        Pojo pojo = (Pojo) Register.getBean("com.zhukai.pattern.singleton.register.Pojo");
                        System.out.println(pojo + "---" + x);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            // 没每创建一个线程就countDown
            latch.countDown();
        }
        Thread.sleep(1000);
    }

    @Test
    public void SerializeTest() throws IOException, ClassNotFoundException {
        SerializePojo s1 = SerializePojo.getInstance();
        SerializePojo s2 = null;

        FileOutputStream fos = new FileOutputStream("SerializePojo.obj");

        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(s1);

        oos.flush();

        oos.close();


        FileInputStream fis = new FileInputStream("SerializePojo.obj");

        ObjectInputStream ois = new ObjectInputStream(fis);

        s2 = (SerializePojo) ois.readObject();

        ois.close();

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
    }
}
