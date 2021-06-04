package designPattern.factory.simpleFactory;

/**
 * @Author fuzf
 * @Date 2021/6/4:15:49
 * @Description:
 */
public class SimpleFactoryMain {

    public static void main(String[] args) {
        CarInterface bmw = CarFactory.getInstance("BMW");
        CarInterface benz = CarFactory.getInstance("BENZ");
        bmw.run();

        benz.run();
    }

}
