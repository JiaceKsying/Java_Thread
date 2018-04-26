package com.cn.ThreadTest.synchronizedDemo.block.demo1;

public class Thread1 extends Thread {
    private Task task;

    public Thread1(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        Common.begin1 = System.currentTimeMillis();
        task.doWork();
        Common.end1 = System.currentTimeMillis();
    }
}
