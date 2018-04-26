package com.cn.ThreadTest.synchronizedDemo.Test;

import com.cn.ThreadTest.synchronizedDemo.block.demo1.Common;
import com.cn.ThreadTest.synchronizedDemo.block.demo1.Task;
import com.cn.ThreadTest.synchronizedDemo.block.demo1.Thread1;
import com.cn.ThreadTest.synchronizedDemo.block.demo1.Thread2;

public class TestRun2 {
    public static void main(String[] args) {
        Task task = new Task();
        Thread1 t1 = new Thread1(task);
        t1.start();
        Thread2 t2 = new Thread2(task);
        t2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long begin = Common.begin1;
        if (Common.begin1 > Common.begin2){
            begin = Common.begin2;
        }

        long end = Common.end1;
        if (Common.end2 > Common.end1){
            end = Common.end2;
        }

        System.out.println("耗时" + ((end - begin)/1000) + "s");
    }


}
