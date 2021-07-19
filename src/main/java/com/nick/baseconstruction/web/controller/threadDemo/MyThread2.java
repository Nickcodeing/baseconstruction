package com.nick.baseconstruction.web.controller.threadDemo;

public class MyThread2 {

    private static Object a = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
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
        });

        Thread t2 = new Thread(t1);
        t1.start();
        t2.start();
    }
}
