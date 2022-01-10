package algorithms.number;

/**
 *  累加数
 *
 * @Author: fuzf
 * @Date: 2022/1/10 22:58
 *
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 示例 2：
 *
 * 输入："199100199"
 * 输出：true
 * 解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/additive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AdditiveNumberMain {

    public static void main(String[] args) {

    }

    public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        String first = "", second = "", third = "";
        int n = num.length();
        for (int i = 0; i < n / 2; i++) {
            // 1. 对应0xxxx,且非0000情况
            if (first.length() > 1 && first.charAt(0) == '0') {
                return false;
            }
            for (int j = i + 1; j <= Math.min(n - i, n / 2 + i / 2) + 1; j++) {
                first = num.substring(0, i);
                second = num.substring(i, j);
                // 2. 对应N0xxxx
                if (second.length() > 1 && second.charAt(0) == '0') break;

                // 3. 其他情况，包括 0000 类型
                third = getTarget(first, second);
                if (dfs(second, third, num, j)) {
                    return true;
                }

            }
        }
        return false;

    }


    private static boolean dfs(String second, String third, String num, int index) {
        // DFS搜索到了字符串的结尾，自然结束，即是累加数 true
        if (index == num.length()) return true;
        int len = third.length();
        // 下一次搜索需要找到的数的长度超出字符串剩余的长度，一定搜索不到，false
        if (index + len > num.length()) return false;
        // 取出字符串中与要查找的third长度相等的数
        String subStr = num.substring(index, index + len);
        // 匹配就继续搜索下一轮，否则直接返回false
        if (third.equals(subStr)) {
            return dfs(third, getTarget(second, third), num, index + len);
        } else {
            return false;
        }
    }

    private static String getTarget(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += num1.charAt(i--) - '0';
            if (j >= 0) carry += num2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry /= 10;
        }
        String res = sb.reverse().toString();
        // System.out.println(res);
        return res;
    }

}
