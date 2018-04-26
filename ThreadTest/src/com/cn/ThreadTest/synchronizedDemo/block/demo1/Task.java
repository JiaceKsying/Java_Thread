package com.cn.ThreadTest.synchronizedDemo.block.demo1;

public class Task {
    private String data1;
    private String data2;

    public void doWork(){
        try {
            System.out.println("begin");
            Thread.sleep(3000);
            String s1 = "线程名称：" + Thread.currentThread().getName();
            String s2 = "线程名称：" + Thread.currentThread().getName();

            synchronized(this){
                data1 = s1;
                data2 = s2;
            }

            System.out.println(data1);
            System.out.println(data2);
            System.out.println("end");
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }

}
