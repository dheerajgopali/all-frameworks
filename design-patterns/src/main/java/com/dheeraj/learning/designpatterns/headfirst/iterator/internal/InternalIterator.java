package com.dheeraj.learning.designpatterns.headfirst.iterator.internal;

public class InternalIterator<T> {
    String[] str;

    public InternalIterator(String[] str) {
        this.str = str;
    }

    public void forE(Consmr<T> action) {
        @SuppressWarnings("unchecked")
        final T[] str = (T[])this.str;
        for (int i=0;i<str.length;i++) {
            action.action(str[i]);
        }
    }
}
