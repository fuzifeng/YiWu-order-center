package algorithms.string;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: fuzf
 * @Date: 2021/3/7 15:55
 */
public class AddBinaryMain {

    public static void main(String[] args) {
        System.out.println(solution("110","1011"));

    }

    public static String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < count; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            if (carry == 3) {
                sb.append('1');
                carry = 1;
            } else if (carry == 2) {
                sb.append('0');
                carry = 1;
            } else if (carry == 1) {
                sb.append('1');
                carry = 0;
            } else {
                sb.append('0');
                carry = 0;
            }
        }
        if (carry > 0) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
