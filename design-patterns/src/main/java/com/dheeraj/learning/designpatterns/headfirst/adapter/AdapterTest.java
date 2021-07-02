package com.dheeraj.learning.designpatterns.headfirst.adapter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class AdapterTest {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("test");
        vector.add("test2");
        Enumeration<String> enumeration = vector.elements();
        EnumerationIterator iterator = new EnumerationIterator(enumeration);
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");

        IterationEnumerator enumerator = new IterationEnumerator(list.iterator());
        while(enumerator.hasMoreElements()) {
            System.out.println(enumerator.nextElement());
        }
    }
}
