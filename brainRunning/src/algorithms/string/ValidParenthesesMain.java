package algorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author fuzf
 */
public class ValidParenthesesMain {
    public static HashMap<Character, Character> map = new HashMap<>();
    static HashSet<Character> left = new HashSet<>();
    static HashSet<Character> right = new HashSet<>();

    static {
        map.put('(', ')');
        map.put(')', '(');
        map.put('[', ']');
        map.put(']', '[');
        map.put('{', '}');
        map.put('}', '{');

        left.add('(');
        left.add('[');
        left.add('{');
        right.add(')');
        right.add(']');
        right.add('}');
    }

    public static void main(String[] args) {
        System.out.println(solution("()[]{}}"));
    }

    public static Boolean solution(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character cur = s.charAt(i);
            if (left.contains(cur)) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.peek();
                if (map.get(top).equals(cur)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
