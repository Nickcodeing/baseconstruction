package com.nick.baseconstruction.web.controller.threadDemo;

public class MyThread extends Thread {

    private Integer a = 0; //线程可以交替打印（）
    //private Object a = new Object();  只会打印第一个数字

    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + "---" + i);
                a.notify();
                try {
                    a.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());
        Thread t2 = new Thread(new MyThread());
        t1.start();
        t2.start();
    }

}
