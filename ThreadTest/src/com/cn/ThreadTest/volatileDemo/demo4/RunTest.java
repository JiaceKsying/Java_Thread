package com.cn.ThreadTest.volatileDemo.demo4;

public class RunTest {
    public static void main(String[] args) {
        MyThread[] t1 = new MyThread[100];
        for (int i = 0; i < 100; i++){
            t1[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++){
            t1[i].start();
        }
    }
}
