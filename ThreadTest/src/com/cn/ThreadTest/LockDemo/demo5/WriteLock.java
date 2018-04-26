package com.cn.ThreadTest.LockDemo.demo5;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteLock {
    public static void main(String[] args) {
        MyService s = new MyService();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "正在运行");
                s.Write();
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

        public void Write(){
            lock.writeLock().lock();
            try{
                System.out.println("获得写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.writeLock().unlock();
            }
        }
    }
}
