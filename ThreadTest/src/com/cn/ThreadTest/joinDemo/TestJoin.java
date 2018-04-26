package com.cn.ThreadTest.joinDemo;

public class TestJoin {
    public static void main(String[] args) {
        try {
            MyThread t1 = new MyThread();
            t1.start();

            //调用join方法，保证主线程等待t1执行完毕
            t1.join();

            System.out.println("我需要t1的执行结果");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("我先执行");
    }
}
