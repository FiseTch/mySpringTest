package com.fise.security;

import com.alibaba.fastjson.JSON;
import com.fise.domain.MyUser;
import com.fise.repository.MyUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@ComponentScan
public class MyUserDetailService implements UserDetailsService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserRepository userRepository;

    //返回一个UserDetail类型的参数，在这里我们可以自定义一个类实现UserDetail，以此来实现自己数据库的逻辑

    //在这里，我们返回了spring 自有的UserDetail实现类User，但在实际开发中，我们完全可以用自己的类

    //UserDetail 里面的七个参数
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //此处可以通过查询数据库获取自定义数据

        MyUser myUser = userRepository
                .getUser(MyUser.builder().username(username).build());

        String password = passwordEncoder.encode(myUser.getPassword());

        myUser.setPassword(password);
        log.info("当前用户数据： " + JSON.toJSONString(myUser));
        //目前我们先设置一个默认的用户名，密码及权限,spring 5.0之后，修改了对密码的加密方式
        //必须在密码前设置一种加密格式，{noop}表示不使用加密方式，
        //return new MyUser(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return myUser;
    }
}
