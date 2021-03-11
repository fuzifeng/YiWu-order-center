package designPattern.proxy.staticProxy;

/**
 * @author fuzf
 */
public class StaticProxyTestMain {

    public static void main(String[] args) {
        Person person = new Person("张三", "iPhone");
        person.give();

        PersonProxy proxy = new PersonProxy(person);
        proxy.give();

    }

}
