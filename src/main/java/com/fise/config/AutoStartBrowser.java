package com.fise.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;

/**
 * @author tongch -Administrator
 * @version 1.0
 * @classname AutoStartBrowser
 * @date 2019/07/17 22:57
 * @description
 **/

@SpringBootConfiguration
public class AutoStartBrowser implements CommandLineRunner {
    @Value("${server.port}")
    private int port;
    
    @Value("${default_url}")
    private String defaultUrl;
    
    @Override
    public void run(String... args) throws Exception {
        Runtime.getRuntime().exec("cmd /c start http://localhost:" + port + defaultUrl);
    }
}
