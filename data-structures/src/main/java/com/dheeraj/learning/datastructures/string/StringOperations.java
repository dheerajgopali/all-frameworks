package com.dheeraj.learning.datastructures.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dgopali on 9/11/2015.
 */
public class StringOperations {
    public static void main(String[] args) {
        StringOperations so = new StringOperations();
        List<String> list = so.displayCharPermutationsInWord("abcdefg");
        int tot=1;
        for(int i=1;i<=7;i++)
            tot = tot*i;
        System.out.println(tot);
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<String> displayCharPermutationsInWord(String word) {
        if(word.length() == 2){
            List<String> permList = new ArrayList<String>();
            permList.add(word);
            permList.add(""+word.charAt(1)+word.charAt(0));
            return permList;
        } else {
            List<String> permList;
            //Recursively call this method excluding the last character.
            List<String> temp = displayCharPermutationsInWord(word.substring(0,word.length()-1));
            //Add the last character to each string in all possible positions.
            permList = addLastChar(temp,word.charAt(word.length()-1));
            return permList;
        }
    }

    public List<String> addLastChar(List<String> list, char ch) {
        List<String> combList = new ArrayList<String>();
        //Iterate over each string
        for (String word : list) {
            for(int newCharPosition = 0 ; newCharPosition < word.length() + 1 ; newCharPosition++) {
                StringBuffer str = new StringBuffer();
                //To indicate whether a last character is added to the word
                boolean flag = true;

                for (int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
                    if(wordIndex == newCharPosition && flag) {
                        flag = false;
                        str.append(ch);
                        wordIndex--;
                    } else {
                        str.append(word.charAt(wordIndex));
                    }
                }
                if(flag == true) {
                    combList.add(str.toString()+ch);
                }else {
                    combList.add(str.toString());
                }
            }
        }
        return combList;
    }
}
