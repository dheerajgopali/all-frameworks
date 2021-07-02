package com.dheeraj.learning.designpatterns.headfirst.iterator;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] menuItems;
    int position;
    public AlternatingDinerMenuIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
        this.position = Calendar.DAY_OF_WEEK%2;
    }

    @Override
    public boolean hasNext() {
        if(position >= menuItems.length || menuItems[position]==null)
            return false;
        return true;
    }

    @Override
    public MenuItem next() {
        MenuItem item = menuItems[position];
        position = position+2;
        return item;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException(
                "Alternating Diner Menu Iterator does not support remove()");
    }
}
