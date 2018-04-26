package com.cn.ThreadTest.synchronizedDemo.block.demo2;

public class Service {
    public void testMethod1(MyObject object){
        synchronized(object) {
            try {
                System.out.println("获得锁的时间：" + System.currentTimeMillis() + " 当前线程的名称：" + Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("获得锁的时间：" + System.currentTimeMillis() + " 当前线程的名称：" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
