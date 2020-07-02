package com.springboot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-aop
 * @description: 切面类
 * @author: myitconfig
 * @create: 2020-04-08 10:55
 **/

@Component
@Aspect
public class BasketballGameCut {

    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     *通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution( public * com.springboot.aop.controller.BasketballGameController.*(..))")
    public void brokerAspect(){}
    /**
     * @description  使用环绕通知
     */
    @Around("brokerAspect()")
    public Object doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        Object url=null;
        try{
            System.out.println("经纪人正在处理球星赛前事务!");
            url= pjp.proceed();
            System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");

        }
        catch(Throwable e){
            System.out.println("异常通知：球迷要求退票！");
        }
        return url;
    }
//    /**
//     * @description  在连接点执行之前执行的通知
//     */
//    @Before("brokerAspect()")
//    public void doBeforeGame(){
//        System.out.println("经纪人正在处理球星赛前失误!");
//    }
//
//    /**
//     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
//     */
//    @After("brokerAspect()")
//    public void doAfterGame(){
//        System.out.println("球星获得了本厂比赛的mvp");
//    }
//
//    /**
//     * @description  在连接点执行之后执行的通知（返回通知）
//     */
//    @AfterReturning("brokerAspect()")
//    public void doAfterReturningGame(){
//        System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");
//    }
//
//    /**
//     * @description  在连接点执行之后执行的通知（异常通知）
//     */
//    @AfterThrowing("brokerAspect()")
//    public void doAfterThrowingGame(){
//        System.out.println("异常通知：球迷要求退票！");
//    }


}
