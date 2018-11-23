package com.fise.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tongch
 * @version 1.0
 * @time 2018/11/19 17:08
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping(value = "/user_login", method = RequestMethod.POST)
    public ModelAndView userLogin(@RequestParam("user_name") String username, @RequestParam("password") String pwd) {
        ModelAndView mv = new ModelAndView();
        log.info("用户名称为：" + username + "用户密码" + pwd);
        return mv;
    }

    @RequestMapping("/templates/login")
    public String templatesLogin() {
        return "login";
    }

}
