package com.tch.fise.test;

import com.tch.fise.FiseApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailTest extends FiseApplicationTests {

    @Autowired
    private JavaMailSender javaMailSender;


    //邮件发送测试 -- 自动从配置文件中获取发送人信息
    @Test
    public void testMail() {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("2289717264@qq.com");
        simpleMailMessage.setTo("1293669406@qq.com");
        simpleMailMessage.setText("spring boot mail test");
        simpleMailMessage.setSubject("happy day");
        javaMailSender.send(simpleMailMessage);

    }
}
