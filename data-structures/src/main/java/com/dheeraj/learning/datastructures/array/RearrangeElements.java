package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/19/2015.
 */
public class RearrangeElements {
    public static void main(String[] args) {
        RearrangeElements re = new RearrangeElements();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(0);
        list.add(2);
        list.add(1);
        list.add(3);
        //4, 0, 2, 1, 3
        System.out.println(list);
        re.arrange(list);
        System.out.println(list);
    }

    public void arrange2(ArrayList<Integer> a) {
        int counter=0;
        int i=0;
        int initialVal=a.get(0);
        while(counter!=a.size()){
            int temp=a.get(i);
            if(temp!=0)
                a.set(i,a.get(a.get(i)));
            else {
                a.set(i, initialVal);
                break;
            }
            i=temp;
            counter++;
        }
    }

    public void arrange3(ArrayList<Integer> a){
        ArrayList<Integer> list = new ArrayList<Integer>(a);
        for(int i=0;i<a.size();i++){
            list.set(i,a.get(a.get(i)));
        }
        a.removeAll(a);
        a.addAll(list);
    }

    public void arrange(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            System.out.println("I : "+A.get(A.get(i))+" "+A.get(A.get(i))%n);
            A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
        }
        for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
    }
}
