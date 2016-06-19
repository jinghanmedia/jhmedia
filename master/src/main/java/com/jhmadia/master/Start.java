/*========================================
 * 项目名：婧涵影视-master
 * 文件名：Start.java
 * 备    注：中国广东省广州市番禺区大石镇植村村五路(海珠区客村新港中路影盛花园C栋2508室)
 * CopyRigth (C) 2015-2016 jhmedia 婧涵影视
 *========================================*/
package com.jhmadia.master;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

/**
 * 类   名：启动类
 * <pre>
 * 概   要：使用jetty这个servlet容器启动本项目
 * 作成者：Seki2016
 * 作成日：2016年6月19日
 *
 * </pre>
 */
public class Start {

    public static void main(String[] args) {

        // 加载日志配置文件 start
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure("master_config/logback.xml");
        } catch (JoranException e) {}
    }

}
