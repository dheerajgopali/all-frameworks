package com.dheeraj.learning.datastructures.tree;

import com.dheeraj.learning.utilities.ListUtility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dgopali on 11/15/2015.
 */
public class OrderOfPersonsHeight {
    public static void main(String[] args) {
        OrderOfPersonsHeight obj = new OrderOfPersonsHeight();
        ArrayList<Integer> list = obj.order(new ArrayList<Integer>(ListUtility.buildList("5,3,2,6,1,4")), new ArrayList<Integer>(ListUtility.buildList("0,1,2,0,3,2")));
        System.out.println(list);
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<Person> list = new ArrayList<Person>();
        for (int i = 0; i < heights.size(); i++) {
            list.add(new Person(heights.get(i), infronts.get(i)));
        }

        Collections.sort(list);
        ArrayList<Integer> resList = new ArrayList<Integer>();
        int[] res = new int[heights.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            int counter = -1;
            int temp = 0;
            while (counter != p.infronts) {
                if (res[temp++] == -1) {
                    counter++;
                }
            }
            res[temp - 1] = p.height;

        }
        for (int i = 0; i < res.length; i++) {
            resList.add(res[i]);
        }

        return resList;
    }


}

class Person implements Comparable<Person> {
    int height;
    int infronts;

    public Person(int ht, int inf) {
        height = ht;
        infronts = inf;
    }

    public int compareTo(Person o) {
        return new Integer(height).compareTo(o.height);
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", infronts=" + infronts +
                '}';
    }
}