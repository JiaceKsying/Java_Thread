package com.cn.ThreadTest.Test;

import com.cn.ThreadTest.threadbase.MyRunnable;

public class RunnableDemo {
    public static void main(String[] args) {
        MyRunnable run = new MyRunnable();
        Thread t = new Thread(run);
        t.start();
        System.out.println("ok");
    }
}
