package com.dheeraj.learning.datastructures.self;

/**
 * Created by dgopali on 9/26/2015.
 */
public class Tree {
    String value;
    public Tree left;
    public Tree right;

    public Tree(String value){
        this.value = value;
    }

    public Tree addLeft(String value) {
        left = new Tree(value);
        return left;
    }

    public Tree addRight(String value) {
        right = new Tree(value);
        return right;
    }
}
