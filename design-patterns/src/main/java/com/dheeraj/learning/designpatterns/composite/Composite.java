package com.dheeraj.learning.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    List<Component> list = new ArrayList<Component>();
    String name;

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(Component c) {
        list.add(c);
    }
    public void showPrice() {
        System.out.println("Name : "+name);
        for (Component cs :
                list) {
            cs.showPrice();
        }
    }
}
