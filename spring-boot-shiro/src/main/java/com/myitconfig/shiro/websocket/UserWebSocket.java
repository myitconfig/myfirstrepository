package com.myitconfig.shiro.websocket;

import com.myitconfig.shiro.config.MyEndpointConfigure;
import com.myitconfig.shiro.util.OnlineCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: spring-boot-shiro
 * @description: websocket监听方法
 * @author: myitconfig
 * @create: 2020-02-21 11:12
 **/

@Component
@ServerEndpoint(value = "/userWebSocket/{userId}")
public class UserWebSocket {
    private Logger log = LoggerFactory.getLogger(UserWebSocket.class);
    private static CopyOnWriteArraySet<UserWebSocket> webSocketSet = new CopyOnWriteArraySet<>(); // concurrent包的线程安全Set，用来存放每个客户端对应的UserWebSocket对象。
    private Session session;    // 与某个客户端的连接会话，需要通过它来给客户端发送数据

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
            log.info("推送消息成功，消息为：" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendInfo(String message) {
        for (UserWebSocket productWebSocket : webSocketSet) {
            productWebSocket.sendMessage(message);
        }
    }

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) {
        log.info("新客户端连入，用户id：" + userId);
        this.session = session;
        webSocketSet.add(this);
        OnlineCountUtil.addOnlineCount();
        if (userId != null) {
            List<String> totalPushMsgs = new ArrayList<>();
            totalPushMsgs.add(userId + "连接成功-" + "-当前在线人数为：" + OnlineCountUtil.getOnlineCount());
            if (totalPushMsgs != null && !totalPushMsgs.isEmpty()) {
                totalPushMsgs.forEach(e -> sendMessage(e));
            }
        }
    }

    @OnClose
    public void onClose() {
        log.info("一个客户端关闭连接");
        webSocketSet.remove(this); // 从set中删除
        OnlineCountUtil.subOnlineCount(); // 在线数减1
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("用户发送过来的消息为：" + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("websocket出现错误");
        error.printStackTrace();
    }
}