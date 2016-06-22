package com.jhmedia.master.web.common;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jhmedia.master.util.PageData;

public class BaseController {

    public static final Logger logger = LoggerFactory.getLogger(
        BaseController.class);
    
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

    /**
     * 取得request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

}
