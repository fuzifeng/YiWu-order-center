package designPattern.proxy.dynamicProxy;

public class IBuyAppleImpl implements BuyAppleInterface {
    @Override
    public void buyApple() {
        System.out.println("买一个苹果");
    }
}
