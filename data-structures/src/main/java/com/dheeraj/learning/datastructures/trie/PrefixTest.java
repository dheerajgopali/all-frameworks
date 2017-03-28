package com.dheeraj.learning.datastructures.trie;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by dgopali on 11/9/2015.
 */
public class PrefixTest {
    public static void main(String[] args) {
        PrefixTest obj = new PrefixTest();
        System.out.println(obj.prefix(ArrayUtil.buildArray("zebra,dog,duck,dot")));

    }

    public ArrayList<String> prefix(ArrayList<String> a) {
        Trie trie = Trie.create(a);
        ArrayList<String> list = new ArrayList<String>();
        for(String str : a){
            list.add(trie.getUniquePrefix(str));
        }

        return list;
    }
}