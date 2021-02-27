package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 有返回值 并且 可以抛出异常、捕获异常
 * @author fuzf
 */
public class CallableMain {
    public static void main(String[] args) {
        CallableThreadDemo demo = new CallableThreadDemo();
        FutureTask<Integer> result = new FutureTask<>(demo);
        new Thread(result).start();
        // 2.接收线程运算后的结果
        try {
            Integer sum =  result.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class CallableThreadDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0; i<=100;i++){
            System.out.println(i);
            sum+=i;
        }
        return sum/0;
    }
}
