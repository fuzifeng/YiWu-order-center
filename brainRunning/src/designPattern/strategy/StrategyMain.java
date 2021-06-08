package designPattern.strategy;

/**
 * 策略模式
 * 定义了一系列的算法 或 逻辑 或 相同意义的操作，并将每一个算法、逻辑、操作封装起来，而且
 * 使它们还可以相互替换。（其实策略模式Java中用的非常非常广泛）
 * 我觉得主要是为了 简化 if...else 所带来的复杂和难以维护。
 *
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性非常良好。
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 *
 * @Author fuzf
 * @Date 2021/6/7:17:05
 * @Description:
 */
public class StrategyMain {

    public static void main(String[] args) {
        Context context;
        context = new Context(new PayStrategyA());
        context.algorithmInterface();
        context = new Context(new PayStrategyB());
        context.algorithmInterface();

    }
}
