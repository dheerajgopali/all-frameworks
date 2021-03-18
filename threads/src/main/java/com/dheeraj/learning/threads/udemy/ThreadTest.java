package com.dheeraj.learning.threads.udemy;

import java.util.function.UnaryOperator;

/**
 * https://www.udemy.com/course/java-multithreading-concurrency-performance-optimization/
 *
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadTest obj = new ThreadTest();
        obj.visibilityTest();

    }

    public ThreadTest() {
    }

    public void miscellaneous() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Test: "+Thread.currentThread().getName());
            }
        });
        Thread thread2 = new Thread(() -> System.out.println("test2"));
        System.out.println("Thread name: "+Thread.currentThread().getName() + " before start");
        thread.start();
        System.out.println("Thread name: "+Thread.currentThread().getName() + " AFTER start");
        thread2.start();
    }
    public void visibilityTest() {
        SharedResource sharedResource = new SharedResource();
        ThreadSub thread1 = new ThreadSub(true, sharedResource);
        ThreadSub thread2 = new ThreadSub(false, sharedResource);
        thread1.start();
        thread2.start();
    }
}

class SharedResource {
    boolean flag=true;
}

class ThreadSub extends Thread {
    boolean isThread1;
    SharedResource sr;

    public ThreadSub(boolean isThread1, SharedResource sr) {
        this.isThread1 = isThread1;
        this.sr = sr;
    }

    @Override
    public void run() {
        if(isThread1) {
            System.out.println("Setting flag false in thread1");
            sr.flag = false;
            System.out.println("Flag set");
        }else {
            System.out.println("In thread 2");
            while (sr.flag) {
                System.out.println("flag");
            }
            System.out.println("thread 2 done");
        }
    }
}
