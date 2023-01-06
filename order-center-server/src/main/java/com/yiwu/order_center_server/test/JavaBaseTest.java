package com.yiwu.order_center_server.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaBaseTest {

    public static void main(String[] args) {



        String s = "[\"军官\",\"儿童\",\"白痴\"]";
        if (s != null && s.length() > 2) {
        }


        List<String> list4 = new ArrayList<String>();
        list4 = Arrays.asList(s);
        int i = 0;

        BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println(bigDecimal.compareTo(BigDecimal.ZERO));
    }

}
