package designPattern.factory.simpleFactory;

/**
 * @Author fuzf
 * @Date 2021/6/4:15:45
 * @Description:
 */
public class BMW implements CarInterface {
    @Override
    public void run() {
        System.out.println("我是宝马汽车...");
    }
}
