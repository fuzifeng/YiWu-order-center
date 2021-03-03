package algorithms.number;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class PowxNMain {
    public static void main(String[] args) {

        System.out.println(solution(2.0, 10));
//        System.out.println(solution(2.1, 3));
//        System.out.println(solution(2.0, -2));

    }

    public static double solution(double x, int n) {
        double ans = 1.0;
        if (n < 0) {
            x = 1 / deal(x, n * -1);
        } else {
            x = deal(x, n );
        }
        return x;
    }

    public static double deal(double x, int n) {
        while (n != 1) {
            if (n % 2 == 1) {
                x *=x;
                n = n - 1;
            } else {
                x = x * x * x;
                n = n / 2;

            }
        }
        return x;
    }
}
