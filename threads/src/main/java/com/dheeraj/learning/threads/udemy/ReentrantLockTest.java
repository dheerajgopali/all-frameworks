package com.dheeraj.learning.threads.udemy;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable runnable = ()->{
            if(lock.tryLock()) {
                System.out.println("Lock Acquired: "+Thread.currentThread().getName());
            } else {
                System.out.println("Didn't acquire lock: "+Thread.currentThread().getName());
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        thread2.start();
        thread1.start();
    }
}
