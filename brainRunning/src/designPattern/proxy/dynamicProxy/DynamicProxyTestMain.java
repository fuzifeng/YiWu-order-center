package designPattern.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTestMain {

    public static void main(String[] args) {
        IHelloImpl iHello = new IHelloImpl();
        iHello.sayHello();

        DynamicProxy dynamicProxy = new DynamicProxy(iHello);
        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance(
                iHello.getClass().getClassLoader(),
                iHello.getClass().getInterfaces(),
                dynamicProxy
        );
        helloInterface.sayHello();

        IBuyAppleImpl iBuyApple = new IBuyAppleImpl();
        DynamicProxy proxy = new DynamicProxy(iBuyApple);
        BuyAppleInterface buyAppleInterface = (BuyAppleInterface) Proxy.newProxyInstance(
                iBuyApple.getClass().getClassLoader(),
                iBuyApple.getClass().getInterfaces(),
                proxy
        );
        buyAppleInterface.buyApple();

    }
}
