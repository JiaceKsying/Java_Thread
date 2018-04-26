package com.cn.ThreadTest.synchronizedDemo.block.demo1;

public class Task2 {
    private String data1;
    private String data2;

    public synchronized void doWork(){
        try {
            System.out.println("begin");
            Thread.sleep(3000);
            data1 = "线程名称：" + Thread.currentThread().getName();
            data2 = "线程名称：" + Thread.currentThread().getName();
            System.out.println(data1);
            System.out.println(data2);
            System.out.println("end");
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }

}
