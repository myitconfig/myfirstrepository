package com.myitconfig.shiro.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import javax.websocket.server.ServerEndpointConfig;

/**
 * @program: spring-boot-shiro
 * @description: websocket节点配置类
 * @author: myitconfig
 * @create: 2020-02-21 10:54
 **/
public class MyEndpointConfigure extends ServerEndpointConfig.Configurator implements ApplicationContextAware {
    private static volatile BeanFactory context;

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) {
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            MyEndpointConfigure.context=applicationContext;
    }
}
