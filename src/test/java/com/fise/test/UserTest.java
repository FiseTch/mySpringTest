package com.fise.test;

import com.alibaba.fastjson.JSON;
import com.fise.FiseApplicationTests;
import com.fise.domain.MyRole;
import com.fise.domain.MyUser;
import com.fise.repository.MyUserRepository;
import com.fise.util.MyDateUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Slf4j
public class UserTest extends FiseApplicationTests {

    @Autowired
    private MyUserRepository userRepository;


    @Test
    public void testAddUser() {
        MyUser myUser = MyUser.builder().username("aaa").password("111")
                .myrole(MyRole.builder().userRole("admin").expirePeriod(100)
                        .id(2).isAccountValid(false)
                        .isLocked(false)
                        .pwdChangeTime(new Date())
                        .PwdValidPeriod(100)
                        .build()).build();

        MyUserRepository.addMyUser(myUser);
    }


    @Test
    public void getUser() {

        //MyUser user = MyUserRepository.getUser(MyUser.builder().username("ttt").build());

        MyUser user = userRepository.getUser(MyUser.builder().username("ttt").build());


        System.out.println(MyDateUtils.dayToNow(user.getMyrole().getCreateDate()));

        String s = JSON.toJSONString(user);
        log.info(s);
    }
}
