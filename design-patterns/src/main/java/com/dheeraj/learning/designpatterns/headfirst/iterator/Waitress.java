package com.dheeraj.learning.designpatterns.headfirst.iterator;

import java.util.Iterator;
import java.util.List;

public class Waitress {
    List<Menu> menuList;

    public Waitress(List<Menu> menuList) {
        this.menuList = menuList;
    }
    public void printMenu() {
        for (Menu menu : menuList) {
            Iterator<MenuItem> menuItemIterator = menu.createIterator();
            printMenu(menuItemIterator);
        }
    }
    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }
    // other methods here
}
