package designPattern.proxy.dynamicProxy;

public class IHelloImpl implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("say hello");
    }
}
