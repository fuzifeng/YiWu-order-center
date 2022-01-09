package algorithms.number;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 *
 * @Author: fuzf
 * @Date: 2022/1/6 23:32
 *
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ZigzagConversionMain {

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        String convert = convert1(str, 3);
        System.out.println(convert);

    }

    public static String convert1(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int row = 0;
        boolean xiayi = true;
        for (char c : s.toCharArray()) {
            list.get(row).append(c);
            if (xiayi) {
                if (row < numRows - 1) {
                    row++;
                } else {
                    row--;
                    xiayi = false;
                }
            } else {
                if (row == 0) {
                    row++;
                    xiayi = true;
                } else {
                    row--;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();

    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = s.length();
        int step = numRows * 2 - 2;
        int index = 0;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            index = i;
            add = i * 2;
            while (index < length) {
                sb.append(chars[index]);
                add = step - add;
                index += (i == 0 || i == numRows - 1) ? step : add;
            }
        }

        return sb.toString();
    }
}
