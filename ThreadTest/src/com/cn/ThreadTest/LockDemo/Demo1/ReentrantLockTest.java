package com.cn.ThreadTest.LockDemo.Demo1;

import com.cn.ThreadTest.synchronizedDemo.block.demo2.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread t1 = new MyThread(service);
        MyThread t2 = new MyThread(service);
        MyThread t3 = new MyThread(service);
        MyThread t4 = new MyThread(service);
        MyThread t5 = new MyThread(service);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
    static public class MyService{
        private Lock lock = new ReentrantLock();
        public void testMethod(){
            lock.lock();
            try{
                for (int i = 0; i < 5; i++){
                    System.out.println("name:" + Thread.currentThread().getName() + " " + (i + 1));
                }
            }finally {
                lock.unlock();
            }
        }
    }

    static public class MyThread extends Thread{
        private MyService service;

        public MyThread(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.testMethod();
        }
    }
}
