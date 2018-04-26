package com.cn.ThreadTest.volatileDemo.demo1;

public class RunTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
        Thread.sleep(2000);
        t1.setRunning(false);

        System.out.println("isRunnable = false");
    }
}
