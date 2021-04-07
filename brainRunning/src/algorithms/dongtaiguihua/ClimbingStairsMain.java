package algorithms.dongtaiguihua;

/**
 * @Author: fuzf
 * @Date: 2021/3/7 18:45
 */
public class ClimbingStairsMain {



    /**
     * 递归的方式
     *
     * @param n
     * @return
     */
    public static int solution1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return solution1(n - 1) + solution1(n - 2);
    }
}
