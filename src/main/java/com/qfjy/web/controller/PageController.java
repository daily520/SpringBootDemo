package com.qfjy.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author daily
 * @date 2019/11/15 19:16
 */
@Controller
public class PageController {
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("test")
    public String test(){
        return "test";
    }
    @RequestMapping("unauth")
    public String unauth(){
        return "unauth";
    }

}
