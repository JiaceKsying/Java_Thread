package com.cn.ThreadTest.synchronizedDemo.Test;

import com.cn.ThreadTest.synchronizedDemo.block.demo2.MyObject;
import com.cn.ThreadTest.synchronizedDemo.block.demo2.Service;
import com.cn.ThreadTest.synchronizedDemo.block.demo2.Thread1;
import com.cn.ThreadTest.synchronizedDemo.block.demo2.Thread2;

public class TestRun3 {
    public static void main(String[] args) {
        Service service = new Service();
        MyObject obj1 = new MyObject();
        MyObject obj2 = new MyObject();

        Thread1 t1 = new Thread1(obj1, service);
        t1.setName("a");
        t1.start();

        Thread2 t2 = new Thread2(obj2, service);
        t2.setName("b");
        t2.start();

    }
}
