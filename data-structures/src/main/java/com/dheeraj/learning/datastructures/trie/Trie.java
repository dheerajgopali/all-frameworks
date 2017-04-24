package com.dheeraj.learning.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dgopali on 11/9/2015.
 */
public class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public Trie(List<String> list) {
        root = new TrieNode();
        for(int i=0;i<list.size();i++){
            insert(list.get(i));
        }
    }

    public static Trie create(List<String> list){
        return new Trie(list);
    }

    public String getUniquePrefix(String str){
        StringBuilder temp = new StringBuilder();
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                temp.append(c);
                children = t.children;
                if(t.frequency == 1)
                    break;
            } else {
                return null;
            }
        }
        return temp.toString();
    }

    public TrieNode getNodePrefix(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }

    public List<String> searchUniquePrefixes(){
        List<String> list = new ArrayList<String>();
        //addPrefixes(root, list, new StringBuilder());
        return list;
    }

    public void addPrefixes(TrieNode root, List<String> list, StringBuilder str) {
        if(root.frequency == 1) {
            list.add(str.toString());
            return;
        }

        Map<Character, TrieNode> children = root.children;
        for (TrieNode node : children.values()) {
            str.append(node.c);
            addPrefixes(node, list, str);
            str.deleteCharAt(str.length()-1);
        }
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        HashMap<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            t.frequency++;
            children = t.children;

            //set leaf node
            if (i == word.length() - 1)
                t.isLeaf = true;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if (t != null && t.isLeaf)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null)
            return false;
        else
            return true;
    }

    public TrieNode searchNode(String str) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }

        return t;
    }
}

