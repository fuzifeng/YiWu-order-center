package designPattern.factory.simpleFactory;

/**
 * 简单工厂模式
 *
 * 相当于是一个工厂中有各种产品，创建在一个类中，客户无需知道具体产品的名称，
 * 只需要知道产品类所对应的参数即可。但是工厂的职责过重，而且当类型过多时不利于系统的扩展
 * 维护。
 *
 * 优点：简单工厂模式能够根据外界给定的信息，决定究竟应该创建哪个具体类的对象。明确区分了
 * 各自的职责和权力，有利于整个软件体系结构的优化。
 *
 * 缺点：很明显工厂类集中了所有实例的创建逻辑，容易违反GRASPR的高内聚的责任分配原则
 *
 *
 * @Author fuzf
 * @Date 2021/6/4:15:47
 * @Description:
 */
public class CarFactory {
    public static CarInterface getInstance(String name) {
        if ("BMW".equals(name)) {
            return new BMW();
        } else if ("BENZ".equals(name)) {
            return new BENZ();
        }
        return null;
    }
}
