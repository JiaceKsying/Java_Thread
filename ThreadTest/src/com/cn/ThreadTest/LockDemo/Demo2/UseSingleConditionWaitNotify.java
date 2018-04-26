package com.cn.ThreadTest.LockDemo.Demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseSingleConditionWaitNotify {
    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService();
        MyThread t1 = new MyThread(service);
        t1.start();
        Thread.sleep(3000);
        service.signal();

    }
    static public class MyService{
        private Lock lock = new ReentrantLock();
        public Condition conditon = lock.newCondition();

        public void await(){
            lock.lock();
            try {
                System.out.println("await时间：" + System.currentTimeMillis());
                conditon.await();
                System.out.println("await执行之后的输出");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void signal(){
            lock.lock();
            try{
                System.out.println("signal时间：" + System.currentTimeMillis());
                conditon.signal();
                Thread.sleep(3000);
                System.out.println("signal执行后的输出");
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    static public class MyThread extends Thread{
        private MyService service = new MyService();

        public MyThread(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.await();
        }
    }
}
