package com.cn.ThreadTest.volatileDemo.demo5;

public class RunTest {
    public static void main(String[] args) {
        MyThread[] t1 = new MyThread[1000];
        for (int i = 0; i < 1000; i++){
            t1[i] = new MyThread();
        }

        for (int i = 0; i < 1000; i++){
            t1[i].start();
        }
    }
}
