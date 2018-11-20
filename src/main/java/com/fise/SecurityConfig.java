package com.fise;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //对表单进行验证及授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()//设置表单验证
                .loginPage("")
                .and()//连接
                .authorizeRequests()//对请求授权
                .anyRequest()//任何请求
                .authenticated();//都需要身份认证

//        浏览器弹出一个验证窗口
//       http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
