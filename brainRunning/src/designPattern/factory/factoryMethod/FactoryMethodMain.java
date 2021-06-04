package designPattern.factory.factoryMethod;

/**
 * 工厂方法模式Factory Method，又称多态性工厂模式。
 *
 * 在工厂方法模式中，核心的工厂类不再负
 * 责所有的产品的创建，而是将具体创建的工作交给子类去做。该核心类成为一个抽象工厂角色，仅
 * 负责给出具体工厂子类必须实现的接口，而不接触哪一个产品类应当被实例化这种细节
 *
 * @Author fuzf
 * @Date 2021/6/4:16:16
 * @Description:
 */
public class FactoryMethodMain {

    public static void main(String[] args) {
        Car2Interface aodi = new AodiFactory().create();
        Car2Interface luhu = new LuhuFactory().create();

        aodi.run();
        luhu.run();

    }
}
