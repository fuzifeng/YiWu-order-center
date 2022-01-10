package algorithms.string;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @Author: fuzf
 * @Date: 2022/1/9 15:17
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfPhoneNumberMain {


    public static void main(String[] args) {
        System.out.println(solution("23"));

    }



    public static List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<StringBuilder> tempList = new ArrayList<>();
        List<StringBuilder> result = new ArrayList<>();
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        for (char add : phoneMap.get(chars[0]).toCharArray()) {
            result.add(new StringBuilder(String.valueOf(add)));
        }
        for (int i = 1; i < chars.length; i++) {

            for (StringBuilder sb : result) {
                for (char add : phoneMap.get(chars[i]).toCharArray()) {
                    tempList.add(new StringBuilder(sb).append(add));
                }
            }
            result = tempList;
            tempList = new ArrayList<>();
        }
        List<String> strings = new ArrayList<>(result.size());
        for (StringBuilder sb : result) {
            strings.add(sb.toString());
        }
        return strings;
    }

    public static List<String> solution(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        Queue<String> queue = new LinkedList<>();
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        for (char add : phoneMap.get(chars[0]).toCharArray()) {
            queue.add(String.valueOf(add));
        }
        for (int i = 1; i < chars.length; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String thisStr = queue.poll();
                for (char add : phoneMap.get(chars[0]).toCharArray()) {
                    queue.add(thisStr + String.valueOf(add));
                }
            }
        }
        List<String> strings = new ArrayList<>(queue.size());
        for (String sb : queue) {
            strings.add(sb);
        }
        return strings;
    }
}
