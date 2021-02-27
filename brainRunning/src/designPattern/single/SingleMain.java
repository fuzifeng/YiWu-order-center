package designPattern.single;


public class SingleMain {

    public static void main(String[] args) {
        SingleInnerClass singleLazy = SingleInnerClass.getInstance();
        SingleInnerClass singleLazy2 = SingleInnerClass.getInstance();
         singleLazy = SingleInnerClass.getInstance();
    }
}
