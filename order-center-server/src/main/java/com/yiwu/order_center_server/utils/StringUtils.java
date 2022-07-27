package com.yiwu.order_center_server.utils;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by fuzf on 21/01/07.
 */
public class StringUtils {
    public static void main(String[] args) {
        String name = "互联网营销师（五级/初级工）（直播销售员）";
        System.out.println(queryString(name));

    }


    /**
     * 判断是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return false;
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * String 转List<Long>
     *
     * @param str
     * @return
     */
    public static List<Long> stringToList(String str) {
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        String strArr[] = str.split(",");
        if (str != null && strArr.length > 0) {
            return Arrays.stream(strArr).map(v -> Long.valueOf(v)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * *加密
     *
     * @return
     */
    /*public static String encryption(String oldText, int start, int end) {
        StringBuffer newText = new StringBuffer();
        if (org.apache.commons.lang3.StringUtils.isNotBlank(oldText) && oldText.length() > end && end > start) {
            char[] oldC = oldText.toCharArray();
            char tip = 42;//*
            for (int i = 0; i < oldText.length(); i++) {
                if (i < start || i > end) {
                    newText.append(oldC[i]);
                } else {
                    newText.append(tip);
                }
            }
        }
        return newText.toString();
    }*/

    public static String queryString(String str) {
        if (Strings.isNullOrEmpty(str) || Strings.isNullOrEmpty(str.trim())) {
            return null;
        }
        return str
                .replace("\\", "/\\")
                .replace("%", "/%")
                .replace("'", "/'")
                .replace("_", "/_")
                .replace("/","//")

                ;

    }

    /**
     *  获取uuid
     * @param
     * @return
     * @author fuzf
     * @createAt 2021/12/14 17:11
     * @updateAt 2021/12/14 17:11
     */
    public static String ucode() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }
}
