package algorithms.number;

import java.util.HashMap;

/**
 * @author fuzf
 */
public class RomanToIntegerMain {

    public static HashMap<Character, Integer> hashMap = new HashMap<>();
    static {
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(solution("III"));
    }

    public static int solution(String roman) {
        int ans = 0;
        if (roman.length() == 1) {
            return hashMap.get(roman.charAt(0));
        }
        Character pre = roman.charAt(0);
        for (int i = 1; i < roman.length(); i++) {
            Character cur = roman.charAt(i);
            if (hashMap.get(pre) < hashMap.get(cur)) {
                ans -= hashMap.get(pre);
            } else {
                ans += hashMap.get(pre);
            }
            pre = cur;
        }
        ans += hashMap.get(pre);
        return ans;
    }
}
