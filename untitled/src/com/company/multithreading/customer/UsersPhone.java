package com.company.multithreading.customer;

import com.company.multithreading.producer.SaleOfTickets;

/**
 * @program: untitled
 * @description: 用户的手机
 * @author: myitconfig
 * @create: 2020-04-14 15:37
 **/
public class UsersPhone {
    private final static String PHONE_ID = "00xDD881565";
    private final static String PHONE_NAME = "iphone 6";
    private  String userName;
    /**
     *     售票机售票系统
     */
    private SaleOfTickets saleOfTickets;

    public UsersPhone(SaleOfTickets saleOfTickets,String userName){
        this.saleOfTickets=saleOfTickets;
        this.userName=userName;
    }

    public void getTicket(){
        saleOfTickets.setName(this.userName);
        saleOfTickets.start();
    }
}
