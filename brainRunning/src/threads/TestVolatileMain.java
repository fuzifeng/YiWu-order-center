package threads;

/**
 * @author fuzf
 */
public class TestVolatileMain {
    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread thread = new Thread(threadDemo);
        thread.start();

        while (true){
            if(threadDemo.isFlag()){
                System.out.println("-----------------------------");
                break;
            }
        }
    }

}

class ThreadDemo implements Runnable {

//    private boolean flag = false;
    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
    }

    public boolean isFlag() {
        return flag;
    }
}
