package com.clt.nginxtest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 21:36 2019/6/27
 */
@RestController
public class HelloTest {

    @RequestMapping("/")
    public Map<String,String> hello(HttpSession session, HttpServletRequest request){
        Map<String,String> map =new HashMap(5);
        map.put("hello", "world - 1");
        map.put("SessionID", session.getId());
        map.put("sessionValue", (String) session.getAttribute("cluster:session"));
        map.put("SessionIP", request.getServerName());
        map.put("SessionPort", String.valueOf(request.getServerPort()));
        return map;
    }

    @RequestMapping("/login")
    public String login(HttpSession session){
        session.setAttribute("cluster:session", "clt");
        return "This is Tomcat Server 01 Set SessionAttribute value Success"+session.getId();
    }
}
