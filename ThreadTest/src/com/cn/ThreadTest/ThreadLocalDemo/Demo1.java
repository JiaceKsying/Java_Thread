package com.cn.ThreadTest.ThreadLocalDemo;

import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 4; i++){
                System.out.println("在主线程main中获取变量" + Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            MyThread t = new MyThread();
            t.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static public class Tools{
        public static ThreadLocalEx t1 = new ThreadLocalEx();
    }

    static public class ThreadLocalEx extends ThreadLocal{
        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }
    }
    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                for (int i = 0; i < 4; i++){
                    System.out.println("在线程中获取变量" + Tools.t1.get());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


