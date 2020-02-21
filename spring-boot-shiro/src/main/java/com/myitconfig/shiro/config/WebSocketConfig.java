package com.myitconfig.shiro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @program: spring-boot-shiro
 * @description: websocket配置类
 * @author: myitconfig
 * @create: 2020-02-21 11:06
 **/
@Configuration
public class WebSocketConfig  {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){ return new ServerEndpointExporter();}

    @Bean
    public MyEndpointConfigure myEndpointConfigure(){return new MyEndpointConfigure();}
}
