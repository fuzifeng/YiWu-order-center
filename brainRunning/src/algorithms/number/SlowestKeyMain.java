package algorithms.number;

/**
 * @Author: fuzf
 * @Date: 2022/1/9 14:37
 */
public class SlowestKeyMain {
    public static void main(String[] args) {

        /*[12,23,36,46,62]
"spuda"*/
        System.out.println(slowestKey(new int[]{12,23,36,46,62},"spuda"));

    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int curMaxTime = 0;
        if (releaseTimes.length == 1) {
            return keysPressed.toCharArray()[0];
        }
        curMaxTime = releaseTimes[0];
        char result = keysPressed.toCharArray()[0];
        char[] chars = keysPressed.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int temp = releaseTimes[i] - releaseTimes[i - 1];
            if (temp >= curMaxTime) {
                if (temp == curMaxTime) {
                    result = result > chars[i] ? result : chars[i];
                } else {
                    result = chars[i];
                }
                curMaxTime = temp;
            }
        }
        return result;
    }
}
