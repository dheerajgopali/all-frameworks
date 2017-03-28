package com.dheeraj.learning.datastructures.graph;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by dgopali on 10/5/2015.
 */
public class Node {
    int val;
    public boolean visited;
    HashSet<Node> children = new HashSet<Node>();

    Node(int val){
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (val != node.val) return false;
        return visited == node.visited;

    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + (visited ? 1 : 0);
        return result;
    }

    public void add(Node n){
        children.add(n);
    }

    @Override
    public String toString() {
        String childIds = "[";
        for (Node child : children) {
            childIds += child.val + ",";
        }
        childIds += "]";
        return "Node{" +
                "val=" + val +
                ", visited=" + visited +
                ", children=" + childIds +
                '}';
    }
}
