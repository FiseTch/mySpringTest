package com.tch.fise;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Tongch
 * @version 1.0
 * @time 2018/11/19 17:24
 */

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")//浏览器访问路径
                .setViewName("forward:/index");//映射后的路径
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        
        super.addViewControllers(registry);
    }
    
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
