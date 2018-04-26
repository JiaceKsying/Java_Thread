package com.cn.ThreadTest.synchronizedDemo.keyword;

public class MyThread2 extends Thread {
    private HasSelfPrivateNum num;

    public MyThread2(HasSelfPrivateNum num) {
        super();
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
        num.addI("b");
    }
}
