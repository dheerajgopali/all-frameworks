package com.dheeraj.learning.designpatterns.headfirst.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CafeMenuIterator implements Iterator<MenuItem> {
    Map<String, MenuItem> menuItemMap;
    List<MenuItem> menuItems;
    int pos=0;

    public CafeMenuIterator(Map<String, MenuItem> menuItemMap) {
        this.menuItemMap = menuItemMap;
        menuItems = new ArrayList<>(menuItemMap.values());
    }

    @Override
    public boolean hasNext() {
        return pos < menuItems.size();
    }

    @Override
    public MenuItem next() {
        return menuItems.get(pos++);
    }
}
