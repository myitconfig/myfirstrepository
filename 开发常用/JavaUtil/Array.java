package com.company;

import java.util.Arrays;
import java.util.Stack;

public class Array {

    public static int[] arrLength(){
        // 解决数组长度不可变问题
        int[] arrOld=new int[] {9,8,7};
        //要加入数组的目标元素
        int dst=6;
        //创建一个新数组
        int[] arrNew=new int[arrOld.length+1];
        //把原数组的数据复制到新数组
        for (int i = 0; i < arrOld.length ; i++) {
            arrNew[i]=arrOld[i];
        }
        arrNew[arrOld.length]=dst;
        //新数组替换旧数组
        arrOld=arrNew;
        return arrOld;
    }
    public static int[] arrDelete(){
        int[] arrOld=new int[]{1,2,3,4,5,6};
        //要删除元素的下标
        int dst=3;
        //创建一个新数组长度是原数组的长度减一
        int[] arrNew=new int[arrOld.length-1];
        for (int i = 0; i < arrNew.length ; i++) {
            if (i<dst){
                arrNew[i]=arrOld[i];
            }else {
                arrNew[i]=arrOld[i+1];
            }
        }
        arrOld=arrNew;
        return arrOld;
    }
    public  static Stack<Integer> testStack(){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(41);
        stack.push(5);
        stack.push(15);
        stack.push(13);
        return stack;
    }
    public static void main(String[] args) {
        System.out.println(testStack().pop());
        System.out.println(testStack().peek());
        System.out.println(testStack().empty());
        System.out.println(testStack().);
    }
}
