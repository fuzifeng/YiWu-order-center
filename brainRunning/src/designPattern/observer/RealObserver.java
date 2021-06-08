package designPattern.observer;

/**
 * 具体的，他继承继承Subject类，在这里实现具体业务，在具体项目中，该类会有很多。
 *
 * @Author fuzf
 * @Date 2021/6/8:10:50
 * @Description:
 */
public class RealObserver extends Subject {

    //被观察对象的属性
    private int state;

    public int getState(){
        return state;
    }

    public void setState(int state){
        this.state=state;
        //主题对象(目标对象)值发生改变
        this.notifyAllObserver(state);
    }
}
