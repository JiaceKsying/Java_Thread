package com.cn.ThreadTest.LockDemo.Demo4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairorNofairLock {
    public static void main(String[] args) {
        MyService service = new MyService(false);
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                    service.test();
                }
            }
        };

        Thread[] A = new Thread[5];
        for (int i = 0; i < 5; i++) {
            A[i] = new Thread(r1);
        }

        for (int i = 0; i < 5; i++) {
            A[i].start();
        }
    }
    static public class MyService{
        private Lock lock;

        public MyService(Boolean isFair) {
            lock = new ReentrantLock(isFair);
        }

        public void test(){
            lock.lock();
            try{
                System.out.println("Name:" + Thread.currentThread().getName() + " lock!");
            } finally {
                lock.unlock();
            }
        }
    }
}
