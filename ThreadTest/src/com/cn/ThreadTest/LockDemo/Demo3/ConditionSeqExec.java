package com.cn.ThreadTest.LockDemo.Demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionSeqExec {
    volatile static private int nextPrintWho = 1;
    private static ReentrantLock lock = new ReentrantLock();
    final static private Condition c1 = lock.newCondition();
    final static private Condition c2 = lock.newCondition();
    final static private Condition c3 = lock.newCondition();

    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try{
                    while(nextPrintWho != 1){
                        c1.await();
                    }
                    for (int i = 0; i < 3; i++){
                        System.out.println("T1 " + (i + 1));
                    }
                    nextPrintWho = 2;
                    c2.signal();
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try{
                    while(nextPrintWho != 2){
                        c2.await();
                    }
                    for (int i = 0; i < 3; i++){
                        System.out.println("T2 " + (i + 1));
                    }
                    nextPrintWho = 3;
                    c3.signal();
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread t3 = new Thread(){
            @Override
            public void run() {
                lock.lock();
                try{
                    while(nextPrintWho != 3){
                        c1.await();
                    }
                    for (int i = 0; i < 3; i++){
                        System.out.println("T3 " + (i + 1));
                    }
                    nextPrintWho = 1;
                    c1.signal();
                } catch (InterruptedException e){
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        };

        Thread[] A = new Thread[5];
        Thread[] B = new Thread[5];
        Thread[] C = new Thread[5];
        for (int i = 0; i < 5; i++){
            A[i] = new Thread(t1);
            B[i] = new Thread(t2);
            C[i] = new Thread(t3);

            A[i].start();
            B[i].start();
            C[i].start();
        }
    }
}
