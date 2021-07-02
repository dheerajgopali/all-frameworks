package com.dheeraj.learning.designpatterns.headfirst.iterator;

import java.util.ArrayList;
import java.util.List;

public class MenuTestDrive {
    public static void main(String[] args) {
        List<Menu> list = new ArrayList<>();
        list.add(new PancakeHouseMenu());
        list.add(new DinerMenu());
        list.add(new CafeMenu());

        Waitress waitress = new Waitress(list);
        waitress.printMenu();
    }
}
