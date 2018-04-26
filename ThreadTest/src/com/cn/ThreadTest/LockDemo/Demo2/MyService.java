package com.cn.ThreadTest.LockDemo.Demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition c1 = lock.newCondition();
    public Condition c2 = lock.newCondition();

    public void awaitA(){
        lock.lock();
        try{
            System.out.println("NAME:" + Thread.currentThread().getName() + " await时间：" + System.currentTimeMillis());
            c1.await();
            System.out.println("Name:" + Thread.currentThread().getName() + " await执行完毕的时间：" + System.currentTimeMillis());
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public void awaitB(){
        lock.lock();
        try{
            System.out.println("NAME:" + Thread.currentThread().getName() + " await时间：" + System.currentTimeMillis());
            c2.await();
            System.out.println("Name:" + Thread.currentThread().getName() + " await执行完毕的时间：" + System.currentTimeMillis());
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public void signalAll_A(){
        lock.lock();
        try{
            System.out.println("NAME:" + Thread.currentThread().getName() + " signalAll_A时间：" + System.currentTimeMillis());
            c1.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B(){
        lock.lock();
        try{
            System.out.println("NAME:" + Thread.currentThread().getName() + " signalAll_B时间：" + System.currentTimeMillis());
            c1.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
