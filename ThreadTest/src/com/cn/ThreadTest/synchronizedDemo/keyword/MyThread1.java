package com.cn.ThreadTest.synchronizedDemo.keyword;

public class MyThread1 extends Thread {
    private HasSelfPrivateNum num;

    public MyThread1(HasSelfPrivateNum num) {
        super();
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        num.addI("a");
    }
}
