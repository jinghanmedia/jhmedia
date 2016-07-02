/*========================================
 * 项目名：婧涵影视-master
 * 文件名：Start.java
 * 备    注：中国广东省广州市番禺区大石镇植村村五路(海珠区客村新港中路影盛花园C栋2508室)
 * CopyRigth (C) 2015-2016 jhmedia 婧涵影视
 *========================================*/
package com.jhmedia.master;

import java.util.Properties;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jhmedia.master.constant.MConst;
import com.jhmedia.master.util.PropertiesUtil;

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

    static final Logger logger = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) throws Exception {

        /*
        // 加载日志配置文件 start
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        try {
            configurator.doConfigure("master_config/logback.xml");
        } catch (JoranException e) {
            
        }
        */

        // 加载配置文件
        PropertiesUtil.loadProperties();

        // 端口号
        int port = MConst.port;
        logger.info("Starting server at port {}", port);
        Server server = new Server(port);
        WebAppContext handler = new WebAppContext();

        // 设定handler
        handler.setContextPath("/");
        handler.setBaseResource(Resource.newClassPathResource("/webapp"));
        handler.setMaxFormContentSize(Integer.MAX_VALUE);
        handler.setDefaultsDescriptor("/webdefault.xml");

        server.setHandler(handler);
        server.start();
        logger.info("Server started at port {}", port);
        server.join();
    }

}
