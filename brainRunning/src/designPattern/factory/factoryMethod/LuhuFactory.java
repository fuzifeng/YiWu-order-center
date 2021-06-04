package designPattern.factory.factoryMethod;

/**
 * @Author fuzf
 * @Date 2021/6/4:16:14
 * @Description:
 */
public class LuhuFactory implements Car2Factory {
    @Override
    public Car2Interface create() {
        return new Luhu();
    }
}
