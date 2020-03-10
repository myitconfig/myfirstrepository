package com.myitconfig.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: springboot-rabbitmq
 * @description: 消息接受监听类
 * @author: myitconfig
 * @create: 2020-03-10 20:46
 **/
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的Queue名称
public class DirectReceiver {
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }
}
