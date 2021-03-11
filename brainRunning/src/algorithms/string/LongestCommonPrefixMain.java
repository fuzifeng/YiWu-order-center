package algorithms.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class LongestCommonPrefixMain {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"flower","flow","flight"}));

    }

    public static String solution(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length==1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder("");
        Arrays.sort(strs, new StringLengthCompare());
        System.out.println(strs[0]);

        String shortestStr = strs[0];
        Boolean goon = true;
        int index = 0;
        while (index < shortestStr.length()) {
            Character c = shortestStr.charAt(index);

            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != c) {
                    goon = false;
                    break;
                }
            }
            if (!goon) {
                break;
            }
            index++;
            sb.append(c);
        }
//        int min
        return sb.toString();
    }

    static class StringLengthCompare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }


}
