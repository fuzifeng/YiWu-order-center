/*
 * Copyright (c) 2012, 2021, Wedon and/or its affiliates. All rights reserved.
 *
 */

package javaPackage;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author fuzf
 * @Date 2022/9/1:18:55
 * @Description:
 */

public class DateMain {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE,3);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
//        System.out.println(calendar.getTime());
        System.out.println(endTime(new Date(), calendar.getTime()));
    }

    public static Date endTime(Date date, Date ymd) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ymd);

        calendar.set(Calendar.YEAR, date.getYear());
        calendar.set(Calendar.MONTH, date.getMonth());
        calendar.set(Calendar.DATE, date.getDate());
        return calendar.getTime();
    }
}
