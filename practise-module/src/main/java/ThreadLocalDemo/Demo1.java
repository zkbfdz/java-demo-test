package ThreadLocalDemo;

/**
 * Created by kai.zhu on 2018/4/19/019.
 */
public class Demo1 {

    static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Demo1.threadLocal.set("擎天柱");
                service();
            }
        }).start();
    }

    public static void service () {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Demo1.threadLocal.get());
        dao();
    }

    public static void dao() {
        System.out.println("=================================");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Demo1.threadLocal.get());
    }
}
