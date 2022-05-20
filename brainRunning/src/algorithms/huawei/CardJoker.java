/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package algorithms.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author fuzf
 * @Date 2022/5/20:17:04
 * @Description:
 */

public class CardJoker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split("-");
            System.out.println(helper(arr[0], arr[1]));
        }

    }

    private static String helper(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>() ;
        map.put("A", 14);
        map.put("2", 15);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);

        if (s1.equals("joker JOKER") || s1.equals("JOKER joker")) {
            return s1;
        } else if (s2.equals("joker JOKER") || s2.equals("JOKER joker")) {
            return s2;
        }
        String[] arr1 = s1.split(" ");
        int n1 = map.get(arr1[0]);
        String[] arr2 = s2.split(" ");
        int n2 = map.get(arr2[0]);
        if (isBoom(s2) && isBoom(s1)) {
            return n1 > n2 ? s1 : s2;
        } else if (isBoom(s1)) {
            return s1;
        } else if (isBoom(s2)) {
            return s2;
        } else if (arr1.length == arr2.length) {
            return n1 > n2 ? s1 : s2;
        } else {
            return "ERROR";
        }
    }

    private static boolean isBoom(String s) {
        String[] temp = s.split(" ");
        if (temp.length > 4) {
            return false;
        }
        String first = temp[0];
        for (int i = 1; i < 4; i++) {
            if (!first.equals(temp[i])) {
                return false;
            }
        }
        return true;
    }
}
