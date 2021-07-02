package com.dheeraj.learning.designpatterns.headfirst.iterator.internal;

public class InternalIteratorTestDrive {
    public static void main(String[] args) {
        String[] str = {"2","3"};
        InternalIterator<String> iterator = new InternalIterator<>(str);
        iterator.forE(item-> System.out.println("test: "+item));
    }
}
