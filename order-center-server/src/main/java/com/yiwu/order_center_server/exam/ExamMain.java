/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package com.yiwu.order_center_server.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author fuzf
 * @Date 2022/6/19:21:34
 * @Description:
 */

public class ExamMain {
    // 本题为考试单行多行输入输出规范示例，无需提交，不计分。

    public static HashMap<Integer, Integer> map = new HashMap();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = 0;
        int length = 0;
        Boolean transInt = true;
        List<String> examList = new ArrayList<>();

        while (in.hasNextLine()) {
            String s = in.nextLine();
//            System.out.println(s);
            if (transInt) {
                length = Integer.parseInt(s);
                transInt = false;
            } else {
                examList.add(s);
                i++;
                if (i == length) {
                    f1(examList);
                    transInt = true;
                    i = 0;
                }
            }

        }
/*

        Scanner strSca = new Scanner(System.in);
        while (strSca.hasNextLine()) {
            String s = strSca.nextLine();
            examList.add(s);
            i++;
            if (i == i1) {
                f1(examList);
            }
        }
*/

        /*Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String shortStr = in.nextLine();
            String longStr = in.nextLine();
            System.out.println(function(shortStr, longStr));
        }*/

        /*String shortStr = "ace";
        String longStr = "abcde";
        int function = function(shortStr, longStr);
        System.out.println(function);

*/
    }

    public static void f1(List<String> list) {
        for (String input : list) {
            StringBuilder sb = new StringBuilder();
            char[] chars = input.toCharArray();
            for (int i = 0; i < input.length(); i++) {
                int move = move(i);
                map.put(i, move);
                if (move > 26) {
                    move = move % 26;
                }
                if ((move + (int) chars[i]) > 122) {
                    sb.append((char) (move + (int) chars[i] - 26));
                } else {
                    sb.append((char) (move + (int) chars[i]));
                }
            }
            System.out.println(sb.toString());
        }

    }

    /**
     * 第二题
     *
     * @param shortStr
     * @param longStr
     * @return
     */
    public static int function(String shortStr, String longStr) {
        HashMap<Character, List<Integer>> map = new HashMap<>();

        char[] chars = longStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.get(chars[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(chars[i], list);
            }
        }

        int longStrIndex = -1;
        for (Character c : shortStr.toCharArray()) {
            if (!map.containsKey(c)) {
                return -1;
            }
            List<Integer> integers = map.get(c);
            boolean trueIndex = false;
            for (int i : integers) {
                if (i > longStrIndex) {
                    longStrIndex = i;
                    trueIndex = true;
                    break;
                }
            }
            if (!trueIndex) {
                return -1;
            }
        }
        return longStrIndex;
    }

    //算偏移量
    public static int move(int index) {

        if (index == 0) {
            return 1;
        }
        if (index == 1) {
            return 2;
        }
        if (index == 2) {
            return 4;
        }
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return move(index - 1) + move(index - 2) + move(index - 3);
    }
}
