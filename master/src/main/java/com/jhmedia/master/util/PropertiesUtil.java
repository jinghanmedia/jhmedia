/*====================================================================
 * 项目名：婧涵影视-master
 * 文件名：Properties.java
 * 备    注：中国广东省广州市番禺区大石镇植村村五路(海珠区客村新港中路影盛花园C栋2508室)
 * CopyRigth (C) 2015-2016 jhmedia 婧涵影视
 *====================================================================*/
package com.jhmedia.master.util;

import java.io.FileInputStream;
import java.util.Properties;

import com.jhmedia.master.constant.MConst;

/**
 * <pre>
 * 类   名：配置文件读取 
 * 概   要：读取指定的配置文件，并初始化一些常量
 * 作成者：seki2016
 * 作成日：2016年7月2日
 * </pre>
 */
public class PropertiesUtil {

    /**
     * 加载配置文件的参数
     */
    public static void loadProperties() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream(MConst.MC_FILEPATH));

        if (Tools.isNotEmpty(properties.getProperty(MConst.MC_PNAME_PORT))) {
            if (Tools.isNumber(properties.getProperty(MConst.MC_PNAME_PORT))) {
                MConst.port = Integer.valueOf(
                        properties.getProperty(MConst.MC_PNAME_PORT));
            } else {
                throw new Exception("端口号不正确！");
            }
        } else {
            throw new Exception("配置文件中缺少port配置！");
        }
    }

    public static void main(String[] args) throws Exception {
        loadProperties();

        System.out.println(MConst.port);
    }

}
