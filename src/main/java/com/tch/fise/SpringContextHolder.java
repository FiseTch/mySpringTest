package com.tch.fise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Tongch
 * @version 1.0
 * @time 2018/11/19 17:12
 */

@Component
public class SpringContextHolder implements ApplicationContextAware {
    
    private static ApplicationContext applicationContext;
    
    public static Object getBean(String beanName){
        return getApplicationContext().getBean(beanName);
    }
    
    
    public static <T> T getBean(Class<T> T){
        return getApplicationContext().getBean(T);
    }
    
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
    
}
