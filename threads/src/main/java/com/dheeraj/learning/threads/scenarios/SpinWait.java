package com.dheeraj.learning.threads.scenarios;

/**
 * Created by gopad on 12-03-2017.
 */
public class SpinWait {
    public static void main(String[] args) {
        MonitorClass sw = new MonitorClass();
        ThreadClass1 t1 = new ThreadClass1(sw);
        ThreadClass2 t2 = new ThreadClass2(sw);
        t1.setPriority(10);
        t2.setPriority(1);
        t1.start();
        t2.start();
    }
}

class ThreadClass1 extends Thread {
    MonitorClass mc;

    public ThreadClass1(MonitorClass mc) {
        this.mc = mc;
    }

    public void run() {
        System.out.println("Thread1 : Invoking Thread1 waitTillChange method");
        mc.waitTillChange();
        System.out.println("Thread1 : Control returned from waitTillChange method");
    }
}

class ThreadClass2 extends Thread {
    MonitorClass mc;

    public ThreadClass2(MonitorClass mc) {
        this.mc = mc;
    }

    public void run() {
        System.out.println("Thread2 : Invoking Thread2 change method");
        mc.change();
        System.out.println("Thread2 : Control returned from change method");
    }
}

class MonitorClass {
    private volatile boolean flag = false;

    public void waitTillChange() {
        int a = 0;
        while (!flag) {
            // Thread.sleep(1);
            System.out.println("in loop : " + a++);
        }
    }

    public void change() {
        flag = true;
    }
}
