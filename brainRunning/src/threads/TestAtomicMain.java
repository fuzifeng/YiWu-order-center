package threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author fuzf
 */
public class TestAtomicMain {

    public static void main(String[] args) {
        AtomicDemo demo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo).start();
        }
    }

}

class AtomicDemo implements Runnable {

    private int count = 0;
    private AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(generate());
    }

    private int generate() {
//        return serialNumber.incrementAndGet();
        return count++;
    }
}
