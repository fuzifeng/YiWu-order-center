package designPattern.strategy;

/**
 * @Author fuzf
 * @Date 2021/6/7:17:22
 * @Description:
 */
public class PayStrategyA extends PayStrategy {
    @Override
    void algorithmInterface() {
        System.out.println("微信支付");
    }
}
