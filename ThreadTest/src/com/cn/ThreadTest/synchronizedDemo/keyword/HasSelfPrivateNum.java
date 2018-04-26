package com.cn.ThreadTest.synchronizedDemo.keyword;

public class HasSelfPrivateNum {
    private int num = 0;

    public synchronized void addI(String s){
        try {
            if (s.equals("a")){
                num = 100;
                System.out.println("a set over");
                Thread.sleep(2000);
            } else {
                num = 200;
                System.out.println("b set over");
//                Thread.sleep(2000);
            }
            System.out.println(s + "num:" + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
