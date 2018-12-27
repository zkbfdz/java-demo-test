package ThreadLocalDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kai.zhu on 2018/4/19/019.
 */
public class Demo4 {

    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<String>();
    static ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int j = i;
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    Demo4.threadLocal.set("擎天柱" + j);
                    service();
                }
            });
        }
    }

    public static void service () {
       pool.execute(new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("DAO:" + Demo4.threadLocal.get());
           }
       }));
    }
}
