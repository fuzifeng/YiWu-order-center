package designPattern.proxy.staticProxy;

public class PersonProxy implements GiveInterface {

    private Person person;

    public PersonProxy(Person person) {
        if (person.getClass() == Person.class) {
            this.person = person;
        }
    }

    @Override
    public void give() {
        System.out.println("通过代理实现");
        person.give();
        System.out.println("代理后代码");
    }
}
