package designPattern.proxy.staticProxy;

public class Person implements GiveInterface{
    private String name;
    private String someThing;

    public Person(String name, String someThing) {
        this.name = name;
        this.someThing = someThing;
    }

    public Person() {
    }

    private Person(String name) {
        this.name = name;
        System.out.println(name + " 只有这个名字");
    }


    @Override
    public void give() {
        System.out.println(name + "给了一个" + someThing);
    }
}
