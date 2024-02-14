package com.dailycoder;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedApp {

    private int count = 0;

    public void doWork() {
        Thread thread = new Thread(()->{
            for (int i=0;i<10000;++i){
                count++;
            }
        });

        Thread thread1 = new Thread(()->{
            for (int i=0;i<10000;++i){
               count++;
            }
        });




        thread.start();
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("count::"+count);
    }

    public static void main(String[] args) {

        SynchronizedApp app = new SynchronizedApp();
        app.doWork();
    }
}
