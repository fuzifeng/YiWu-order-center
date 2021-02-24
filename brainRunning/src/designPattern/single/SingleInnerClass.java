package designPattern.single;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 用静态内部类的方式实现单例类，利用了Java 静态内部类的特性：
 *
 * Java 加载外部类的时候，不会创建内部类的实例，只有在外部类使用到内部类的时候才会创建内部类实例。
 *
 * 静态内部类单例优点：
 *
 * 对象的创建是线程安全的。
 * 支持延时加载。
 * 获取对象时不需要加锁。
 * @author fuzf
 */
public class SingleInnerClass {
    public AtomicInteger time = new AtomicInteger(0);

    /**
     * SingletonInner 是一个静态内部类，当外部类 Singleton 被加载的时候，并不会创建 SingletonInner 实例对象。
     *
     * 只有当调用 getInstance() 方法时，SingletonInner 才会被加载，这个时候才会创建 instance。instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。
     *
     */
    private SingleInnerClass() {
        System.out.println("构造了。。。" + time.incrementAndGet() + "次");
    }

    private static class SingletonInner{
        private static final SingleInnerClass SINGLE_INNER_CLASS = new SingleInnerClass();
    }

    public static SingleInnerClass getInstance() {
        return SingletonInner.SINGLE_INNER_CLASS;
    }
}
