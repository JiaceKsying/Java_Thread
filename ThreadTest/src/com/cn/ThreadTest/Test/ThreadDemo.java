package com.cn.ThreadTest.Test;

import com.cn.ThreadTest.threadbase.MyThread;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
//        thread.setDaemon(true);
//        thread.setDaemon(false);
        thread.start();
        try {
//            thread.sleep(5000);
//            thread.interrupt();
            System.out.println(thread.isAlive());
            thread.setDaemon(true);
            System.out.println(thread.getName());
            System.out.println(thread.getId());
            System.out.println(thread.getPriority());
            System.out.println(thread.isDaemon());

            System.out.println(thread.isDaemon());
            System.out.println(thread.isInterrupted());
            System.out.println(thread.interrupted());
//            System.out.println(thread.interrupted());

            thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }
}
