package designPattern.proxy.staticProxy;

public class Person implements GiveInterface{
    private String name;
    private String someThing;

    public Person(String name, String someThing) {
        this.name = name;
        this.someThing = someThing;
    }

    @Override
    public void give() {
        System.out.println(name + "给了一个" + someThing);
    }
}
