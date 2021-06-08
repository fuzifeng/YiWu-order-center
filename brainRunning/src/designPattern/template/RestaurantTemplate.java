package designPattern.template;

/**
 * @Author fuzf
 * @Date 2021/6/7:14:22
 * @Description:
 */
public abstract class RestaurantTemplate {
    public void menu() {
        System.out.println("看菜单");
    }

    public abstract void spotMenu();

    // 3.吃饭业务
    public void havingDinner(){ System.out.println("吃饭"); }

    // 3.付款业务
    abstract void payment();

    // 3.走人
    public void leave() { System.out.println("离开"); }


    //模板通用结构
    public void process(){
        menu();
        spotMenu();
        havingDinner();
        payment();
        leave();
    }
}
