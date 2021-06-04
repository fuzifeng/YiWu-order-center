package designPattern.builder;

/**
 * 1. 需要生成的对象具有复杂的内部结构。
 *
 * 2. 需要生成的对象内部属性本身相互依赖。
 *
 * 与工厂模式的区别是：建造者模式更加关注与零件装配的顺序。
 * JAVA 中的 StringBuilder就是建造者模式创建的，他把一个单个字符的char数组组合起来
 * Spring不是建造者模式，它提供的操作应该是对于字符串本身的一些操作，而不是创建或改变一个
 * 字符串。
 *
 * @Author fuzf
 * @Date 2021/6/4:17:49
 * @Description:
 */
public class PersonDirector {

    public Arms constructPerson(PersonBuilder pb) {
        pb.buildArmor();
        pb.buildHelmet();
        pb.buildWeapon();
        return pb.build();
    }

    public static void main(String[] args) {
        PersonDirector pd = new PersonDirector();
        Arms arms = pd.constructPerson(new ArmsBuilder());
        System.out.println(arms.getHelmet());
        System.out.println(arms.getArmor());
        System.out.println(arms.getWeapon());

    }

}
