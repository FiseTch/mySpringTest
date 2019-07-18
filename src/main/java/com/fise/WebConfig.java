package com.fise;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


/**
 * @author Tongch
 * @version 1.0
 * @time 2018/11/19 17:24
 */

public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        super.addResourceHandlers(registry);
    }


    //在spring security中设置无效
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        super.addViewControllers(registry);
    }
//设置后缀名，根据请求的文档类型，来查找不同的视图以返回对应格式的文档


    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {
        // 匹配结尾 / :会识别 url 的最后一个字符是否为 /
        //eg： localhost:8080/test 与 localhost:8080/test/ 等价
        configurer.setUseTrailingSlashMatch(true);

        // 匹配后缀名：会识别 xx.* 后缀的内容
        //eg： localhost:8080/test 与 localhost:8080/test.jsp 等价
        configurer.setUseSuffixPatternMatch(true);

        super.configurePathMatch(configurer);
    }
}
