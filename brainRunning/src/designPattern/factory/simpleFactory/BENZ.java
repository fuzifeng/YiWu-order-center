package designPattern.factory.simpleFactory;

/**
 * @Author fuzf
 * @Date 2021/6/4:15:46
 * @Description:
 */
public class BENZ implements CarInterface {

    @Override
    public void run() {
        System.out.println("我是奔驰汽车...");
    }
}
