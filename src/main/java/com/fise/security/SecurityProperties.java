package com.fise.security;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "fise.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();


}
