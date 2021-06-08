package designPattern.strategy;

/**
 * @Author fuzf
 * @Date 2021/6/7:17:24
 * @Description:
 */
public class PayStrategyB extends PayStrategy {
    @Override
    void algorithmInterface() {
        System.out.println("支付宝支付");
    }
}
