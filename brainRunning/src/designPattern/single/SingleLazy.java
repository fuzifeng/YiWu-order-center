package designPattern.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fuzf
 */
public class SingleLazy {

    public AtomicInteger time = new AtomicInteger(0);


    private SingleLazy() {
        System.out.println("构造了。。。" + time.incrementAndGet() + "次");
    }

    public static volatile SingleLazy obj = null;


    public static SingleLazy getInstance(){
        if (obj == null) {
            synchronized (SingleLazy.class) {
                if (obj == null) {
                    obj = new SingleLazy();
                }
            }
        }
        return obj;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                System.out.println(SingleLazy.getInstance());
            }).start();
        }
    }

}
