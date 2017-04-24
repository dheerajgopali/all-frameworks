package com.dheeraj.learning.threads.scenarios;

/**
 * Created with IntelliJ IDEA.
 * User: OWNER
 * Date: 27/11/13
 * Time: 7:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class AnonThread {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run(){
                System.out.println("hai");
            }
        };
        t.start();
    }
}
