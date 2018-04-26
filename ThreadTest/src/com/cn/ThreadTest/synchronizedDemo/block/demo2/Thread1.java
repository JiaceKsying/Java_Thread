package com.cn.ThreadTest.synchronizedDemo.block.demo2;

public class Thread1 extends Thread {
    private MyObject object;
    private Service service;

    public Thread1(MyObject object, Service service) {
        super();
        this.object = object;
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}
