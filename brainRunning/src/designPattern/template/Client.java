package designPattern.template;

/**
 * 模板方法模式：
 * 定义一个操作中的算法骨架（父类），而将一些步骤延迟到子类中。 模板方法使
 * 得子类可以不改变一个算法的结构来重定义该算法的
 *
 * 例如：数据库访问的封装、Junit单元测试、servlet中关于doGet/doPost方法的调用等等
 *
 * @Author fuzf
 * @Date 2021/6/7:14:34
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        //调用第一个模板实例
//        RestaurantTemplate restaurantTemplate = new Kfc();
        RestaurantTemplate restaurantTemplate = new McDonald();
        restaurantTemplate.process();
    }
}
