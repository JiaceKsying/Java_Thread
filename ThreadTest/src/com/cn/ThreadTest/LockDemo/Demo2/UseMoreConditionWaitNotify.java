package com.cn.ThreadTest.LockDemo.Demo2;

public class UseMoreConditionWaitNotify {
    public static void main(String[] args) throws InterruptedException{
        MyService service = new MyService();
        MyThread1 t1 = new MyThread1(service);
        t1.setName("A");
        t1.start();

        MyThread2 t2 = new MyThread2(service);
        t2.setName("B");
        t2.start();

        Thread.sleep(3000);

        service.signalAll_A();

    }

    static public class MyThread1 extends Thread{
        private MyService service = new MyService();

        public MyThread1(MyService service) {
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.awaitA();
        }
    }

    static public class MyThread2 extends Thread {
        private MyService service = new MyService();

        public MyThread2(MyService service) {
            this.service = service;
        }

        @Override
        public void run() {
            super.run();
            service.awaitB();
        }
    }
}
