package com.dheeraj.learning.designpatterns.headfirst.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseIterator implements Iterator<MenuItem> {
    ArrayList<MenuItem> list;
    int pos=0;
    public PancakeHouseIterator(ArrayList<MenuItem> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return pos < list.size();
    }

    @Override
    public MenuItem next() {
        return list.get(pos++);
    }
}
