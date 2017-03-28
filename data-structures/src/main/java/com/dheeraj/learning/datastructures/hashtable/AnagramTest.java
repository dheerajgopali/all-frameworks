package com.dheeraj.learning.datastructures.hashtable;


import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dgopali on 11/1/2015.
 */
public class AnagramTest {
    public static void main(String[] args) {
        AnagramTest at = new AnagramTest();
        System.out.println(at.anagrams(ArrayUtil.buildArray("cat,dog,god,act")));
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        int len = a.size();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Character> srcList = new ArrayList<Character>();
        boolean[] isAnagramArray = new boolean[a.size()+1];
        for(int i=0;i<len;i++){
            if(isAnagramArray[i+1])
                continue;
            int wordLen = a.get(i).length();
            char[] chArray = a.get(i).toCharArray();
            ArrayList<Integer> tempRow = new ArrayList<Integer>();
            srcList.clear();
            for(int k=0;k<chArray.length;k++){
                srcList.add(chArray[k]);
            }
            Collections.sort(srcList);
            tempRow.add(i+1);
            int j=i+1;
            for(;j<len;j++){
                if(isAnagramArray[j+1])
                    continue;
                int tempLen = a.get(j).length();
                if(wordLen == tempLen){
                    //Check all characters in tempString contains in set
                    char[] tempArray = a.get(j).toCharArray();
                    ArrayList<Character> tempList = new ArrayList<Character>();
                    for(int k=0;k<tempArray.length;k++){
                        tempList.add(tempArray[k]);
                    }
                    Collections.sort(tempList);

                    if(srcList.equals(tempList)){
                        isAnagramArray[i+1]=true;
                        isAnagramArray[j+1]=true;
                        tempRow.add(j+1);
                    }
                }
            }
            if(j>i+1){
                list.add(tempRow);
            }else{
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(i+1);
                list.add(tempList);
                isAnagramArray[i+1]=true;
            }
        }

        return list;
    }

    public ArrayList<ArrayList<Integer>> anagramsVersion2(final List<String> a) {
        int len = a.size();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Character> set = new ArrayList<Character>();
        boolean[] isAnagramArray = new boolean[a.size()+1];
        for(int i=0;i<len;i++){
            if(isAnagramArray[i+1])
                continue;
            int wordLen = a.get(i).length();
            char[] chArray = a.get(i).toCharArray();
            ArrayList<Integer> tempRow = new ArrayList<Integer>();
            tempRow.add(i+1);
            boolean isAnagram = true;
            int j=i+1;
            for(;j<len;j++){
                if(isAnagramArray[j+1])
                    continue;
                int tempLen = a.get(j).length();
                if(wordLen == tempLen){
                    //Check all characters in tempString contains in set
                    set.clear();
                    for(int k=0;k<chArray.length;k++){
                        set.add(chArray[k]);
                    }
                    isAnagram=true;
                    for(int k=0;k<tempLen;k++){
                        if(set.remove(new Character(a.get(j).charAt(k)))){

                        }else{
                            isAnagram = false;
                            break;
                        }
                    }
                    if(isAnagram){
                        isAnagramArray[i+1]=true;
                        isAnagramArray[j+1]=true;
                        tempRow.add(j+1);
                    }
                }
            }
            if(j>i+1){
                list.add(tempRow);
            }else{
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(i+1);
                list.add(tempList);
                isAnagramArray[i+1]=true;
            }
        }

        return list;
    }
}
