package com.cn.ThreadTest.synchronizedDemo.Test;

import com.cn.ThreadTest.synchronizedDemo.keyword.HasSelfPrivateNum;
import com.cn.ThreadTest.synchronizedDemo.keyword.MyThread1;
import com.cn.ThreadTest.synchronizedDemo.keyword.MyThread2;

public class TestRun {
    public static void main(String[] args) {
        HasSelfPrivateNum n1 = new HasSelfPrivateNum();
        HasSelfPrivateNum n2 = new HasSelfPrivateNum();

        MyThread1 t1 = new MyThread1(n1);
        MyThread2 t2 = new MyThread2(n1);

        t1.start();
        t2.start();

    }
}
