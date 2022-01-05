package algorithms.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: fuzf
 * @Date: 2022/1/6 0:13
 *
 * https://leetcode-cn.com/problems/simplify-path/solution/
 */
public class SimplifyPathMain {
    public static void main(String[] args) {

    }

    public static String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String str : names) {
            if (str == null || str == "" || ".".equals(str) || str.length() == 0) {
                continue;
            }
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
                continue;
            }
            stack.offerLast(str);
        }
        if (stack.isEmpty()) {
            return "/";
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append("/").append(stack.pollFirst());
            }
            return sb.toString();
        }

    }
}
