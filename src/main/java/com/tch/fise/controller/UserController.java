package com.tch.fise.controller;

import com.tch.fise.SpringContextHolder;
import com.tch.fise.WebConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Tongch
 * @version 1.0
 * @time 2018/11/19 17:08
 */

@Controller
@RequestMapping
public class UserController {
    
    @ResponseBody
    @GetMapping("/index")
    public String getUser() {
        SpringContextHolder.getBean(WebConfig.class);
        return "hello";
    }
}
