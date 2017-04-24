package com.dheeraj.learning.miscellaneous;


import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: OWNER
 * Date: 12/10/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class EqualsHashcode {

    public static void main(String[] args) {
        A one = new A(10, "dheeraj");
        A two = new A(10, "dheeraj");
        System.out.println(one.equals(two));
        Set set = new HashSet();
        set.add(one);
        set.add(two);
        System.out.println(set.size());

    }

}

class A {
    private int a;
    private String name;

    A(int a, String name) {
        this.a = a;
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a1 = (A) o;

        if (a != a1.a) return false;
        if (name != null ? !name.equals(a1.name) : a1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
