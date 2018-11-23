package com.fise.security;

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
        /*http
                //设置表单登录跳转到自己的登录页面
                .formLogin().loginPage("/login")
                .loginProcessingUrl("/user_login")
                .and()
                .authorizeRequests()
                //设置跳转后的页面权限
                .antMatchers("/login", "/login.html", "/login_tips.html", "/static/**").permitAll()
                .anyRequest().authenticated();
*/
        http.formLogin()          // 定义当需要用户登录时候，转到的登录页面。
                .and()
                .authorizeRequests()    // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/static/**", "resources/favicon.ico").permitAll()
                .anyRequest()        // 任何请求,登录后可以访问
                .authenticated();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
