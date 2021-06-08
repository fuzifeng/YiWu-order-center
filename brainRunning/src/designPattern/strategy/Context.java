package designPattern.strategy;

/**
 * @Author fuzf
 * @Date 2021/6/7:17:26
 * @Description:
 */
public class Context {
    PayStrategy payStrategy;

    public Context(PayStrategy payStrategy) {
        this.payStrategy = payStrategy;
    }

    public void algorithmInterface() {
        payStrategy.algorithmInterface();
    }

}
