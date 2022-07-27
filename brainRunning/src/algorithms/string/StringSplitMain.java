/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package algorithms.string;/**
 * @Author fuzf
 * @Date 2022/7/4:10:33
 * @Description:
 */
/**
 * https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&rp=1&ru=/exam/oj/ta&qru=/exam/oj/ta&sourceUrl=%2Fexam%2Foj%2Fta%3FtpId%3D37&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * 描述
 * •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 *
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 */
import java.util.Scanner;


public class StringSplitMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String s = in.nextLine();
            printSubString(s);
        }

//        System.out.println();
    }

    public static void printSubString(String s) {
        int length = s.length();
        for (int i = 0; i < length; i = i + 8) {
            if (i + 8 < length) {
                System.out.println(s.substring(i, i + 8));
            } else {
                int temp = i + 8 - length;
                String tempString = "";
                String substring = s.substring(i, length);
                for (int j = 0; j < temp; j++) {
                    tempString += "0";
                }
                System.out.println(substring + tempString);
            }
        }
    }
}
