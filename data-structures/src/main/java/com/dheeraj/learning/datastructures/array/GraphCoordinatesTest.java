package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/15/2015.
 */
public class GraphCoordinatesTest {

    public static void main(String[] args) {
        GraphCoordinatesTest gct = new GraphCoordinatesTest();
        ArrayList<Integer> X = new ArrayList<Integer>();
        ArrayList<Integer> Y = new ArrayList<Integer>();
        X.add(0);Y.add(0);
        X.add(4);Y.add(4);
        X.add(3);Y.add(2);

        System.out.println(gct.coverPoints(X, Y));
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int noOfSteps = 0;
        for(int i=0; i<X.size()-1;i++){
            noOfSteps += Math.max(Math.abs(X.get(i+1)-X.get(i)), Math.abs(Y.get(i+1)-Y.get(i)));
        }
        return noOfSteps;
    }
}
