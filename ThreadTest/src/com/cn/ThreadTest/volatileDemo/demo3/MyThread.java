package com.cn.ThreadTest.volatileDemo.demo3;

public class MyThread extends Thread{
    private boolean isRunning = true;
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
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(sum);
        System.out.println("线程中断！");
    }
}
