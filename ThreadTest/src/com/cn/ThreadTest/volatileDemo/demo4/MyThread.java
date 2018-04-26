package com.cn.ThreadTest.volatileDemo.demo4;

public class MyThread extends Thread {
    private static int count;

    public static void addCount(){
        for (int i = 0; i < 100; i++){
            count = i;
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        super.run();
        addCount();
    }
}
