package com.dheeraj.learning.datastructures.trie;

import java.util.HashMap;

/**
 * Created by dgopali on 11/9/2015.
 */
public class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
    int frequency=0;

    public TrieNode() {
    }

    public TrieNode(char c) {
        this.c = c;
    }
}