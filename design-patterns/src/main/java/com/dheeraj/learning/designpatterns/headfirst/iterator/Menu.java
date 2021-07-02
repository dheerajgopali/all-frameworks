package com.dheeraj.learning.designpatterns.headfirst.iterator;

import java.util.Iterator;

public interface Menu {
    Iterator<MenuItem> createIterator();
}
