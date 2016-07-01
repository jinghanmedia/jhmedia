/*========================================
 * 项目名：婧涵影视-master
 * 文件名：JhmediaBeetlGroupUtilConfiguration.java
 * 备    注：中国广东省广州市番禺区大石镇植村村五路(海珠区客村新港中路影盛花园C栋2508室)
 * CopyRigth (C) 2015-2016 jhmedia 婧涵影视
 *========================================*/
package com.jhmedia.master.web.common;

import java.io.IOException;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

/**
 * 类   名：加载beetl配置
 * <pre>
 * 概   要：beetl 在spring mvc 中的配置 
 * 用户继承此类，并实现 initOther方法,以注册自己的函数，标签等
 * 作成者：Seki2016
 * 作成日：2016年6月22日 17:32
 *
 * </pre>
 */
public class JhmediaBeetlGroupUtilConfiguration extends BeetlGroupUtilConfiguration {

    @Override
    public void init() {
        
        try {
            initGroupTemplate();

            config(groupTemplate);
        } catch (IOException e) {
            throw new RuntimeException("加载GroupTemplate失败", e);
        }

    }

    private void initGroupTemplate() throws IOException {

        // 配置数据加载
        Configuration configuration = Configuration.defaultConfiguration();
        
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/webapp/templates") {
            @Override
            public void init(GroupTemplate gt) {
                this.setAutoCheck(true);
                this.setCharset("UTF-8");
            }
        };
        groupTemplate = new GroupTemplate(resourceLoader, configuration);

        // 设置错误信息
        if (errorHandler != null) {
            groupTemplate.setErrorHandler(errorHandler);
        }

        // 设置共享变量
        if (sharedVars != null) {
            groupTemplate.setSharedVars(sharedVars);
        }
    }

}
