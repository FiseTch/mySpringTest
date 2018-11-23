package com.fise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fise")
public class FiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FiseApplication.class, args);
    }
}
