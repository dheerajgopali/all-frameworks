package com.dheeraj.learning.designpatterns.headfirst.template;

import java.util.List;

public class TestMyStringList {
    public static void main(String[] args) {
        String[] ducks = { "Mallard Duck", "Redhead Duck", "Rubber Duck", "Decoy Duck"};
        MyStringList ducksList = new MyStringList(ducks);
        List ducksSubList = ducksList.subList(2, 4);
        System.out.println(ducksSubList);
    }
}
