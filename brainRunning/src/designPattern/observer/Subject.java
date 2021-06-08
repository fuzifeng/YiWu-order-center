package designPattern.observer;

import java.util.Vector;

/**
 * @Author fuzf
 * @Date 2021/6/8:10:27
 * @Description:
 */
public class Subject {

    //观察者的存储集合，不推荐ArrayList，线程不安全，
    private Vector<ObserverService> list = new Vector<>();

    //注册
    public void register(ObserverService os) {
        list.add(os);
    }

    //移除
    public void remove(ObserverService observerService) {
        list.remove(observerService);
    }

    public void notifyAllObserver(int state) {
        for (ObserverService observerService : list) {
            observerService.update(state);
        }
    }

}
