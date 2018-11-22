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
        //设置访问静态资源
        http
//                .antMatchers("/static/**")
//                "/css/**", "/js/**", "/fonts/**"
//                , "/image/**", "/resources/favicon.ico","/","/**")
//                .permitAll().anyRequest().authenticated()//除了上述match中对应得请求外，其他任何的请求都需要权限
//                .and()
                //设置表单登录跳转到自己的登录页面
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/user_login")
                .and()
                .authorizeRequests()
                //设置跳转后的页面权限
                .antMatchers("/login","/login.html","/login_tips.html","/static/**").permitAll()
                .anyRequest().authenticated();


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
