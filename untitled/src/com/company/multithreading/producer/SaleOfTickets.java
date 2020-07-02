package com.company.multithreading.producer;

/**
 * @program: untitled
 * @description: 售票机系统
 * @author: myitconfig
 * @create: 2020-04-14 15:18
 **/
public class SaleOfTickets extends Thread {
    @Override
    public void run() {
        int i=1;
        while (true) {
            synchronized (TrainTicketMachine.trainTicketMachine) {
                if (TrainTicketMachine.TRAIN_TICKET > 0) {
                    System.out.println("[" + Thread.currentThread().getName() + "抢到了第]" + i + "张票");
                    i++;
                    TrainTicketMachine.TRAIN_TICKET--;
                }else {
                    System.out.println(this.getName()+"一共抢了"+(i-1));
                    break;
                }
            }
        }
    }
}
