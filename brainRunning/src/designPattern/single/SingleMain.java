package designPattern.single;


public class SingleMain {

    public static void main(String[] args) {
        SingleInnerClass singleLazy = SingleInnerClass.getInstance();
        SingleInnerClass singleLazy2 = SingleInnerClass.getInstance();
         singleLazy = SingleInnerClass.getInstance();

        int COUNT_BITS = Integer.SIZE - 3;
        System.out.println(COUNT_BITS);
        int CAPACITY   = (1 << COUNT_BITS) - 1;
        System.out.println(CAPACITY);
    }
}
