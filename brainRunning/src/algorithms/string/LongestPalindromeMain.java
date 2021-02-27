package algorithms.string;

import java.util.HashMap;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class LongestPalindromeMain {

    public static void main(String[] args) {
        System.out.println(solution("babad"));
    }

    private static String solution(String s) {
        int max = 0;
        int left = 0, right = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] m1 = lengthFind(i, i, s, max);
            int[] m2 = lengthFind(i, i + 1, s, max);
            if (m1 != null && max < m1[2]) {
                max = m1[2];
                left = m1[0];
                right = m1[1];
            }
            if (m2 != null && max < m2[2]) {
                max = m2[2];
                left = m2[0];
                right = m2[1];
            }
        }
        return s.substring(left, right+1);
    }

    private static int[] lengthFind(int left, int right, String s, int max) {
        int length = left == right ? -1 : 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            length = length + 2;
        }
        if (max > length) {
            return null;
        }
        int[] result = {left + 1, right - 1, length};
        return result;

    }






}
