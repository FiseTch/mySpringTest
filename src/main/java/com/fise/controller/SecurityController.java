package com.fise.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * spring项目所有的初始路径配置管理类
 */
@Api(value = "用户初始入口", tags = "路径配置")
@Slf4j
@Controller
@RequestMapping
public class SecurityController {


    @ApiOperation(value = "入口1", tags = "入口1")
    @RequestMapping("/")
    public String userEntrance1() {
        return "login";
    }

    @ApiOperation(value = "入口2", tags = "入口2")
    @RequestMapping("/index")
    public String userEntrance2() {
        return "login";
    }

    @ApiOperation(value = "入口3", tags = "入口3")
    @RequestMapping("/login")
    public String userEntrance3() {
        return "login";
    }


}
