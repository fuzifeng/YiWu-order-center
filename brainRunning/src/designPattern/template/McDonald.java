package designPattern.template;

/**
 * @Author fuzf
 * @Date 2021/6/7:14:30
 * @Description:
 */
public class McDonald extends RestaurantTemplate {

    @Override
    public void spotMenu() {
        System.out.println("汉堡包");
    }

    @Override
    void payment() {
        System.out.println("支付宝支付16元");
    }
}
