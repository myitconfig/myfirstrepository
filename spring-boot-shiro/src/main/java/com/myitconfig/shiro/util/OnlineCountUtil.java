package com.myitconfig.shiro.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: spring-boot-shiro
 * @description: 在线人数计数器
 * @author: myitconfig
 * @create: 2020-02-21 11:50
 **/
public class OnlineCountUtil {

    private static final AtomicInteger atomicInteger=new AtomicInteger(0);

    public static synchronized int getOnlineCount() { return atomicInteger.get();}//获得在线人数

    public static synchronized void addOnlineCount() { atomicInteger.incrementAndGet();}//在线人数+1

    public static synchronized void subOnlineCount() { atomicInteger.decrementAndGet();}//在线人数-1

}
