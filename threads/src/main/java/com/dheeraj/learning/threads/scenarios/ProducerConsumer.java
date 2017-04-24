package com.dheeraj.learning.threads.scenarios;

/**
 * Created by gopad on 28-03-2017.
 */
public class ProducerConsumer {

    public static void main(String args[]) {
        Q q = new Q();
        new Consumer(q);
        new Producer(q);
        System.out.println("Press Control-C to stop.");
    }
}

class Q {
    int n;
    boolean valueSet = false;
    synchronized int get() {
        if(!valueSet)
            try {
                System.out.println("wait in get: "+n);
                wait();
                System.out.println("after wait int get: "+n);
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: " + n);
        valueSet = false;
        System.out.println("Called notify for get : "+n);
        notify();
        System.out.println("After notify for get : "+n);
        return n;
    }

    synchronized void put(int n) {
        if(valueSet)
            try {
                System.out.println("wait in put : "+n);
                wait();
                System.out.println("after wait in put: "+n);
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        System.out.println("Called notify for put : "+n);
        notify();
        System.out.println("After notify for put : "+n);
    }
}

class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    public void run() {
        while(true) {
            q.get();
        }
    }
}

