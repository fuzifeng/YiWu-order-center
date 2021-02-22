package com.yiwu.order_center_server.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuzf
 */
public class BaseTest {
    public static void main(String[] args) {
        Object object = new Object();
        list();
    }

    public static void list() {
        ArrayList l1 = listInstance();
        for (Object o : l1) {
            System.out.println(o);
            l1.remove(o);
        }
    }

    public static ArrayList listInstance() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        return arrayList;
    }

}

class Bean{
    int a;
}
