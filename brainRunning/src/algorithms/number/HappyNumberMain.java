package algorithms.number;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: fuzf
 * @Date: 2021/4/27 0:12
 */
public class HappyNumberMain {

    public static void main(String[] args) {
        System.out.println(isHappy2(2));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = newN(n);
            if (!set.add(n)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = newN(slow);
            fast = newN(fast);
            fast = newN(fast);
        }
        while (slow != fast);
        if (slow == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int newN(int n) {
        int cur = 0;
        int tempNum = 0;
        while (n > 0) {
            tempNum = n % 10;
            n = n / 10;
            cur += tempNum * tempNum;
        }
        return cur;
    }
}
