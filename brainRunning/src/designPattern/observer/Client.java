package designPattern.observer;

/**
 *
 * 观察者模式，是一种行为性模型，又叫发布-订阅模式，他定义对象之间一种一对多的依赖关系，
 * 使得当一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。
 *
 * 职责：观察者模式主要用于1对N的通知。当一个对象的状态变化时，他需要及时告知一系列对象，令他
 * 们做出相应。
 *
 *  实现有两种方式：
 * 1. 推：每次都会把通知以广播的方式发送给所有观察者，所有的观察者只能被动接收。
 * 2. 拉：观察者只要知道有情况即可，至于什么时候获取内容，获取什么内容，都可以自主决定。
 *
 *  观察者模式应用场景
 * 1. 关联行为场景，需要注意的是，关联行为是可拆分的，而不是“组合”关系。事件多级触发场景。
 * 2. 跨系统的消息交换场景，如消息队列、事件总线的处理机制。
 *
 *
 * @Author fuzf
 * @Date 2021/6/8:10:58
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        RealObserver subject = new RealObserver();
        // 创建多个观察者
        ObserverServiceImpl obs1 = new ObserverServiceImpl();
        ObserverServiceImpl obs2 = new ObserverServiceImpl();
        ObserverServiceImpl obs3 = new ObserverServiceImpl();
        // 注册到观察队列中
        subject.register(obs1);
        subject.register(obs2);
        subject.register(obs3);
        // 改变State状态
        subject.setState(300);
        System.out.println("obs1观察者的MyState状态值为："+obs1.getMyState());
        System.out.println("obs2观察者的MyState状态值为："+obs2.getMyState());
        System.out.println("obs3观察者的MyState状态值为："+obs3.getMyState());
        // 改变State状态
        subject.setState(400);
        System.out.println("obs1观察者的MyState状态值为："+obs1.getMyState());
        System.out.println("obs2观察者的MyState状态值为："+obs2.getMyState());
        System.out.println("obs3观察者的MyState状态值为："+obs3.getMyState());
    }

}
