package com.dheeraj.learning.threads;

/**
 * Created by gopad on 24-03-2017.
 */
public class Executor {
    public static String obj="abc";
    public static void main(String[] args) {
        Thread t1 = new Thread("Thread 1"){
            public void run(){
                synchronized (obj) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("In thread 1");
                        try {
                            obj.wait();
                            obj.notify();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread("Thread 2"){
            public void run(){
                synchronized (obj) {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("In thread 2");
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
