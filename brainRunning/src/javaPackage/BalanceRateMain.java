/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package javaPackage;

import java.util.Random;

/**
 * @Author fuzf
 * @Date 2022/7/2:14:51
 * @Description:
 */

public class BalanceRateMain {

    public static void main(String[] args) {
        int t =0;
        int f = 0;
        for (int i = 0; i < 1000; i++) {
//            Boolean aBoolean = dealFunc();
            Boolean aBoolean = dealFuncInt2();
//            Boolean aBoolean = dealFuncInt();
//            Boolean aBoolean = func();
            if (aBoolean) {
                t++;
                System.out.println(true);
            } else {
                f++;
                System.out.println(false);
            }
        }
        System.out.println("true:" + t + ", false:" + f);

//        for (int i = 0; i < 10; i++) {
//            System.out.println(func());
//        }
    }

    public static Boolean dealFunc() {
        Boolean func1 = func(); //20% true
        Boolean func2 = func();


        // 1 true
        return func1.equals(func2);

//        return (func1 || func2) || (!func1 || !func2);
    }
    public static Boolean dealFuncInt() {
        int func1 = funcInt(); //20% true
        int func2 = funcInt();

        return (func1 + func2) > 1000;
    }

    public static Boolean dealFuncInt2() {
        Boolean func1 = func(); //20% true
        Boolean func2 = func();
        int i = func1 ? 2 : 8;
        int j = func2 ? 8 : 2;
        return (i + j) == 10;
    }

    public static int funcInt() {
        int t =0;
        int f = 0;
        Random random = new Random();
        int j = random.nextInt(1000);
        return j;
    }

    public static Boolean func() {
        int t =0;
        int f = 0;
        Random random = new Random();
        int j = random.nextInt(1000);
            if (j < 200) {
                t++;
//                System.out.println(true);
                return true;
            } else {
                f++;
//                System.out.println(false);
                return false;
            }
//        for (int i = 0; i < 100; i++) {
//            int j = random.nextInt(10);
//            if (j < 3) {
//                t++;
//                System.out.println(true);
//            } else {
//                f++;
//                System.out.println(false);
//            }
//        }
//        System.out.println("true:" + t + ", false:" + f);
//        return true;

    }

}

