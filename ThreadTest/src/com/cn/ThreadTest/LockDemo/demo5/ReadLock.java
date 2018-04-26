package com.cn.ThreadTest.LockDemo.demo5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadLock {
    public static void main(String[] args) {
        MyService s = new MyService();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                s.Read();
            }
        };
        Thread[] A = new Thread[5];
        for(int i = 0; i < 5; i++){
            A[i] = new Thread(r);
        }

        for(int i = 0; i < 5; i++){
            A[i].start();
        }
    }

    static public class MyService{
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        public void Read(){
            lock.readLock().lock();
            try{
                System.out.println("获得读锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.readLock().unlock();
            }
        }
    }
}
