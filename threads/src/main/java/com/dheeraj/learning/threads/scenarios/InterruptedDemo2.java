package com.dheeraj.learning.threads.scenarios;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class InterruptedDemo2 extends Thread{

    ReentrantLock lock = new ReentrantLock();

    public void run(){
        try{
            System.out.println("Trying to acquire lock for "+getName());
            lock.tryLock(10, TimeUnit.MILLISECONDS);
            System.out.println("Acquired lock for "+getName());
        } catch (InterruptedException ie) {
            System.out.println(ie);
            ie.printStackTrace();
        } finally {
            if(lock.isLocked())
                lock.unlock();
        }
    }

    public static void main(String args[]){

        InterruptedDemo2 t1=new InterruptedDemo2();
        InterruptedDemo2 t2=new InterruptedDemo2();

        t1.start();

        t2.start();

        t1.interrupt();
    }
}  