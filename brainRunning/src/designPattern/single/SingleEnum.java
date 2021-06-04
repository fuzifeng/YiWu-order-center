package designPattern.single;

/**
 * @Author fuzf
 * @Date 2021/6/4:15:30
 * @Description:
 */
public class SingleEnum {


    public static void main(String[] args) {
        SingleEnum s1 = SingleEnum.getInstance();
        SingleEnum s2 = SingleEnum.getInstance();
        SingleEnum s3 = SingleEnum.getInstance();
        System.out.println(s1 == s2);
    }

    public static SingleEnum getInstance() {
        return InnerEnum.INNER_ENUM.getInstance();
    }

    private static enum InnerEnum{
        INNER_ENUM;

        private SingleEnum singleEnum;

        private InnerEnum() {
            System.out.println("枚举私有构造参数");
            singleEnum = new SingleEnum();
        }

        public SingleEnum getInstance() {
            return singleEnum;
        }
    }
}
