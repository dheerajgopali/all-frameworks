package com.dheeraj.learning.designpatterns.builder;

/**
 * Builder pattern :
 * Build a phone with required specifications. Here PhoneBuilder is used to create phone object with min specifications set.
 * Here is phone is complex object and using builder pattern, building phone becomes easy at the client side.
 */
public class Exec {
    public static void main(String[] args) {
        //Create phone object
        //Create phone builder
        //Instantiate phone object using phone builder
        //print phone specifications.
        Phone phone = new PhoneBuilder().setOs("Android").setCost(1000).getPhone();
        System.out.println(phone);
    }
}
