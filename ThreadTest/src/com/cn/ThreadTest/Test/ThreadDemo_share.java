package com.cn.ThreadTest.Test;

import com.cn.ThreadTest.threadbase.MyThread_share;

public class ThreadDemo_share {
    public static void main(String[] args) {
        MyThread_share thread = new MyThread_share();
        Thread t1 = new Thread(thread,"A");
        Thread t2 = new Thread(thread,"B");
        Thread t3 = new Thread(thread,"C");
        Thread t4 = new Thread(thread,"D");
        Thread t5 = new Thread(thread,"F");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
