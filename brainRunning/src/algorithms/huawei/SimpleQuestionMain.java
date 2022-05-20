/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package algorithms.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author fuzf
 * @Date 2022/5/20:17:44
 * @Description:
 */


public class SimpleQuestionMain {

    public static void main(String[] args) {
        //length1
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        System.out.println(length1(s));

        //charNum
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        Scanner in2 = new Scanner(System.in);
        String s2 = in2.nextLine();
        System.out.println(charNum(s, s2.charAt(0)));
    }

    /**
     * HJ1 字符串最后一个单词的长度
     *
     * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&tqId=21224&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3Fdifficulty%3D2%26page%3D1%26pageSize%3D50%26search%3D%26tpId%3D37%26type%3D37&difficulty=2&judgeStatus=undefined&tags=&title=
     * @param s
     * @return
     */
    private static int length1(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }

    /**
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
     *
     * @param s
     * @param c
     * @return
     */
    private static Integer charNum(String s, char c) {
//        int total = s.length();
//        String s2 = s.replaceAll(String.valueOf(Character.toUpperCase(c)), "").replaceAll(String.valueOf(Character.toLowerCase(c)), "");
//        return s2.length() - total;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char temp : s.toCharArray()) {
            temp = Character.toUpperCase(temp);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp,1);
            }
        }
        if (map.containsKey(Character.toUpperCase(c))) {
            return map.get(Character.toUpperCase(c));
        } else {
            return 0;
        }
    }

}
