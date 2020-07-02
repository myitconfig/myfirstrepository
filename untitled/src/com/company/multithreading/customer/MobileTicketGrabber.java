package com.company.multithreading.customer;

import com.company.multithreading.producer.SaleOfTickets;

/**
 * @program: untitled
 * @description: 手机抢票器
 * @author: myitconfig
 * @create: 2020-04-14 15:30
 **/
public class MobileTicketGrabber {


    public static void main(String[] args) {
        new UsersPhone(new SaleOfTickets(),"iphone 6").getTicket();
        new UsersPhone(new SaleOfTickets(),"iphone 7").getTicket();
        new UsersPhone(new SaleOfTickets(),"iphone 8").getTicket();
        new UsersPhone(new SaleOfTickets(),"iphone x").getTicket();
        new UsersPhone(new SaleOfTickets(),"iphone 5").getTicket();
    }
}
