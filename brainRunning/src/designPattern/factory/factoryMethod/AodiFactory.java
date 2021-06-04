package designPattern.factory.factoryMethod;

/**
 * @Author fuzf
 * @Date 2021/6/4:16:12
 * @Description:
 */
public class AodiFactory implements Car2Factory {
    @Override
    public Car2Interface create() {
        return new Aodi();
    }
}
