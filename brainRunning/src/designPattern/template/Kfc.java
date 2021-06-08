package designPattern.template;

/**
 * @Author fuzf
 * @Date 2021/6/7:14:29
 * @Description:
 */
public class Kfc extends RestaurantTemplate {

    @Override
    public void spotMenu() {
        System.out.println("全家桶");
    }

    @Override
    void payment() {
        System.out.println("微信支付88元");
    }
}
