package com.dheeraj.learning.performance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PerformanceMeasurer {

    public static void main(String[] args) throws InterruptedException {
        ServiceTobetested stt = new ServiceTobetested();
        measureMethodTime(stt, "serve");
    }

    /**
     * The below method uses java reflection to invoke a method in the given object.
     * It calculates the time taken to execute the given method.
     *
     * TODO: Yet to implement for method with parameters
     *
     * @param obj An object whose method is invoked
     * @param str The method which is to be invoked
     */
    public static void measureMethodTime(Object obj, String... str){
        Class cls = obj.getClass();
        Method m=null;
        long totalTime=0;
        try {
            m = cls.getMethod(str[0]);
            long startTime = System.nanoTime();
            m.invoke(obj);
            long endTime   = System.nanoTime();
            totalTime = endTime - startTime;

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //long totalTimeInseconds = totalTime/1000000000;
        System.out.println("Total time taken by method - "+cls.getName()+"."+m.getName()+" is : "+totalTime+" nanoseconds");
    }

}
