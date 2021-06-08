package designPattern.observer;

/**
 * 定义具体观察者
 *
 * @Author fuzf
 * @Date 2021/6/8:10:17
 * @Description:
 */
public class ObserverServiceImpl implements ObserverService {
    // 具体观察者的属性
    private int myState;

    @Override
    public void update(int n) {
        myState = n;
        System.out.println("收到消息,myState值改为：" + myState);
    }

    public int getMyState() {
        return myState;
    }

}
