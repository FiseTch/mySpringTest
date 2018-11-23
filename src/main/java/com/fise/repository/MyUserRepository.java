package com.fise.repository;


import com.fise.SpringContextHolder;
import com.fise.domain.MyUser;
import com.fise.service.IMyUserService;
import com.fise.util.MyDateUtils;
import org.springframework.data.domain.Example;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class MyUserRepository {


    public static void addMyUser(MyUser user) {
        SpringContextHolder.getBean(IMyUserService.class).saveAndFlush(user);
    }

    public static MyUser getUser(MyUser user) {
        //todo 无法使用getOne()方法
        //  这是一个测试

        MyUser myUser = SpringContextHolder.getBean(IMyUserService.class).findOne(Example.of(user)).get();

        return myUser;
    }

    public static Collection<? extends GrantedAuthority> getAuthorities(MyUser user) {
        return null;
    }


    /**
     * 当前账号是否过期
     *
     * @param user
     * @return
     */
    public boolean isAccountNonExpired(MyUser user) {
        int day = MyDateUtils.dayToNow(user.getMyrole().getCreateDate());
        return (user.getMyrole().getExpirePeriod() > day) ? true : false;
    }

    /**
     * 当前账户是否被锁定
     *
     * @param user
     * @return
     */
    public boolean isAccountNonLocked(MyUser user) {
        return user.getMyrole().isLocked();
    }

    /**
     * 当前密码是否过期
     *
     * @param user
     * @return
     */
    public boolean isCredentialsNonExpired(MyUser user) {
        int day = MyDateUtils.dayToNow(user.getMyrole().getPwdChangeTime());
        return (user.getMyrole().getPwdValidPeriod() > day) ? true : false;
    }

    /**
     * 当前账户是否注销
     *
     * @param user
     * @return
     */
    public boolean isEnabled(MyUser user) {
        return user.getMyrole().isAccountValid();
    }
}
