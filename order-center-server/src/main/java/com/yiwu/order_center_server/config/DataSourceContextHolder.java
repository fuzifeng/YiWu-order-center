package com.yiwu.order_center_server.config;

/**
 * @Author fuzf
 * @Date 2021/9/10:15:50
 * @Description:
 */
public class DataSourceContextHolder {
    private static final ThreadLocal<String> context = new ThreadLocal<>();

    public static void set(String dataSourceType) {
        context.set(dataSourceType);
    }

    public static String get() {
        return context.get();
    }

    public static void remove() {
        context.remove();
    }
}
