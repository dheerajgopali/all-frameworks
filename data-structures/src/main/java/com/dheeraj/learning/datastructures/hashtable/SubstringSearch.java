package com.dheeraj.learning.datastructures.hashtable;


import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dgopali on 11/4/2015.
 */
public class SubstringSearch {
    public static void main(String[] args) {
        SubstringSearch obj = new SubstringSearch();
        //System.out.println(obj.findSubstring("barfoothefoobarman", ArrayUtil.buildArray("foo,bar")));
        System.out.println(obj.findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa ",
                ArrayUtil.buildArray("aaa,aaa,aaa,aaa,aaa")));
    }

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(a.isEmpty() || b.isEmpty()){
            return result;
        }
        int lenS = a.length();
        int lenL = b.get(0).length()*b.size();
        int lenLWord = b.get(0).length();
        if(lenL > lenS){
            return result;
        }
        LinkedList<String> list = new LinkedList<String>(b);
        StringBuilder source = new StringBuilder(a);
        for(int i=0 ; i<lenS ; i++){
            int tempI = i;
            if(list.isEmpty()){
                list.addAll(b);
            }
            while(tempI+lenLWord <= lenS){
                String word = source.substring(tempI,tempI+lenLWord);
                if(list.contains(word)){
                    list.remove(word);
                    tempI = tempI+lenLWord;
                }else{
                    break;
                }
                if(list.isEmpty()){
                    result.add(i);
                    break;
                }
            }
            list.clear();
        }

        return result;
    }

    public ArrayList<Integer> findSubstringV2(String S, final List<String> L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(S.isEmpty() || L.isEmpty()){
            return result;
        }
        int lenS = S.length();
        int lenL = L.get(0).length()*L.size();
        int lenLWord = L.get(0).length();
        if(lenL > lenS){
            return result;
        }
        LinkedList<String> tempSet = new LinkedList<String>(L);
        StringBuilder source = new StringBuilder(S);
        for(int i=0 ; i<lenS ; i++){
            int tempI = i;
            if(tempSet.isEmpty()){
                tempSet.addAll(L);
            }
            while(tempI+lenLWord <= lenS){
                String word = source.substring(tempI,tempI+lenLWord);
                if(tempSet.contains(word)){
                    tempSet.remove(word);
                    tempI = tempI+lenLWord;
                }else{
                    break;
                }
                if(tempSet.isEmpty()){
                    result.add(i);
                    break;
                }
            }
            tempSet.clear();
        }

        return result;
    }
}