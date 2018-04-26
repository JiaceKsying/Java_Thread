package com.cn.ThreadTest.synchronizedDemo.block.demo1;

public class Thread2 extends Thread {
    private Task task;

    public Thread2(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        Common.begin2 = System.currentTimeMillis();
        task.doWork();
        Common.end2 = System.currentTimeMillis();
    }
}
