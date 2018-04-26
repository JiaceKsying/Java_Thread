package com.cn.ThreadTest.Test;

import com.cn.ThreadTest.threadbase.MyThread_noshare;

public class ThreadDemo_noshare {
    public static void main(String[] args) {
        // 数据不共享，就是每次都启动一个线程来执行，相互间没有影响
        MyThread_noshare thread = new MyThread_noshare("A");
        MyThread_noshare thread1 = new MyThread_noshare("B");
        MyThread_noshare thread2 = new MyThread_noshare("C");
        thread.start();
        thread1.start();
        thread2.start();

    }
}
