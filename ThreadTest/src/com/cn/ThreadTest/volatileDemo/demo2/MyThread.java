package com.cn.ThreadTest.volatileDemo.demo2;

public class MyThread extends Thread{
    volatile private boolean isRunning = true;
    int sum = 0;

    public boolean isRunning(){
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    @Override
    public void run() {
        super.run();
        System.out.println("进入run");
        while (isRunning) {
            int a = 1;
            int b = 2;
            sum = a + b;
        }
        System.out.println(sum);
        System.out.println("线程中断！");
    }
}
