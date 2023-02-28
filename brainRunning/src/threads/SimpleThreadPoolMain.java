package threads;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Wd
 */
public class SimpleThreadPoolMain {

    public static void main(String[] args) {
        LinkedBlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 16; i++) {
            threadPoolExecutor.execute(
//                    new Thread((Runnable) new SimpleThreadPoolMain(), "Thread".concat(i + ""))
                    new Thread()
            );
            System.out.println("线程池中活跃的线程数： " + threadPoolExecutor.getPoolSize());
            if (queue.size() > 0) {
                System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPoolExecutor.shutdown();

    }

}
