/*====================================================================
 * 项目名：婧涵影视-master
 * 文件名：Tools.java
 * 备    注：中国广东省广州市番禺区大石镇植村村五路(海珠区客村新港中路影盛花园C栋2508室)
 * CopyRigth (C) 2015-2016 jhmedia 婧涵影视
 *====================================================================*/
package com.jhmedia.master.util;

/**
 * <pre>
 * 类    名：工具类 
 * 概    要：定义有关字符串、日期等的操作
 * 作成者：seki2016
 * 作成日：2016年7月1日
 * </pre>
 */
public class Tools {

    /**
     * 判断字符串是否为空（null、""、"null"）
     * @param str
     * @return 如果为空，则返回true；否则，返回false
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    /**
     * 判断字符串是否不为空（null、""、"null"）
     * @param str
     * @return 如果不为空，则返回true；否则，返回false
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str) && !"null".equals(str);
    }

    /**
     * 判断是否是数字（正则表达式）
     * @param value
     * @return 满足指定的正则表达式，则返回true；否则返回false。
     */
    public static boolean isNumber(String value) {
        String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?0\\.\\d*)$";
        return value.matches(regex);
    }

}
