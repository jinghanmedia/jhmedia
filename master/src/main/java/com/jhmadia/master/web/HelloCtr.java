package com.jhmadia.master.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/helloworld")
public class HelloCtr {

    @RequestMapping("/helloSay")
    public ModelAndView hellSay(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();

        String userName = "";
        userName = request.getParameter("username");

        Map<String, String> user = new HashMap<String, String>();
        user.put("username", userName);

        mv.addObject("user", user);
        mv.setViewName("/success.html");
        return mv;
    }
}
