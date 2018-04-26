package com.cn.ThreadTest.threadbase;

public class MyThread_noshare extends Thread {

    private int count = 5;

    public MyThread_noshare(String name) {
        super(name);
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("当前count由" + MyThread_noshare.currentThread().getName() + "计算出" + count);
        }
    }
}
