package com.dheeraj.learning.datastructures;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by dgopali on 10/7/2015.
 */
public class Inheritance {
    public static void main(String[] args) throws ParseException {
        /*SuperClass sc = new SuperClass();
        SubClass sub = new SubClass();
        sub.method1();
        SuperClass sr= new SubClass();
        sr.method1();*/

        System.setProperty("user.timezone", "PST");
        TimeZone.setDefault(null);
        Date d1 = new Date(1257062400000L);
        long db = d1.getTime() + 3600001L;
        System.out.println(db);
        Date d2 = new Date(db);
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        System.out.println(f.format(d1));
        System.out.println(f.format(d2));
            System.out.println(f.format(d1).equals(f.format(d2)));  // true
        System.out.println(d1.equals(f.parse(f.format(d1))));   // false
        System.out.println(d1);                                 // Sun Nov 01 01:00:00 PDT 2009
        System.out.println(d2);                                 // Sun Nov 01 01:00:00 PST 2009
    }
}

class SuperClass{

    public void method1(){
        if (this instanceof SuperClass){ //pseudocode
            method2();
        }
        //do some more stuff
    }

    public void method2(){
        System.out.println("super method 2");
    }
}

class SubClass extends SuperClass{

   /* @Override
    public void method1(){
        method2();
        super.method1();
    }*/

    /*@Override
    public void method2(){
        System.out.println("sub method 2");
    }*/

}