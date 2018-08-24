package ThreadLocalDemo;

/**
 * Created by kai.zhu on 2018/4/19/019.
 */
public class Demo2 {

    static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Demo2.threadLocal.set("擎天柱");
                service();
            }
        }).start();
    }

    public static void service () {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Demo2.threadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao();
            }
        }).start();
    }

    public static void dao() {
        System.out.println("=================================");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Demo2.threadLocal.get());
    }
}
