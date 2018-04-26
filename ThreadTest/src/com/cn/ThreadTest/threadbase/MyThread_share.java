package com.cn.ThreadTest.threadbase;

public class MyThread_share extends Thread {
    private int count = 5;

    @Override
    public synchronized void run() {
        super.run();
        count--;
        System.out.println("当前count由" + MyThread_noshare.currentThread().getName() + "计算出" + count);
    }
}
