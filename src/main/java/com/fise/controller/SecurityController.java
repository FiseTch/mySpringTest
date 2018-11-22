package com.fise.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
@Controller
@RequestMapping
public class SecurityController {


    @RequestMapping("/user")
    public String userTest() {
        return "test";
    }


    @RequestMapping("/login")
    public String securityEntrance(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //获取浏览器访问路径
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName() + " started");

        StringBuffer requestURL = request.getRequestURL();

        log.info(requestURL.toString());
        //获取访问路径的相对path eg:/login
        String path = requestURL.toString().substring(requestURL.toString().lastIndexOf("9") + 1);

        log.info(path);
        //设置自定义路径
        if (StringUtils.endsWithIgnoreCase(requestURL.toString(), ".html")
                || path.equals("/") || path.equals("/index")) {
            log.info(path);
            return "login";
        } else {
            return "login_tips";
        }

    }


}
