package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dgopali on 10/29/2015.
 */
public class LetterPhone {
    public static void main(String[] args) {
        LetterPhone obj = new LetterPhone();
        System.out.println(obj.letterCombinations("23"));
    }

    /*public ArrayList<String> letterCombinations(String a) {
        //Get each character digit
        ArrayList<String> list = new ArrayList<String>();
        int len = a.length();
        for(int i=0;i<len;i++){
            char ch = a.charAt(i);
        }
        //Get convert them to correponding chars
        //Add chars one by one
        return null;
    }*/

    public ArrayList<String> letterCombinations(String digits) {
        String[] letters = {"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> rec = new LinkedList<String>();
        StringBuilder string = new StringBuilder();
        letterCombinations(digits, 0, letters, string, rec);
        return new ArrayList<String>(rec);
    }

    private void letterCombinations(String digits, int number, String[] letters, StringBuilder string, List<String> rec) {
        if (digits.length() == number) {
            rec.add(string.toString());
            return;
        }
        String letter = letters[digits.charAt(number)-'0'];
        for (int i = 0; i < letter.length(); i++) {
            string.append(letter.charAt(i));
            letterCombinations(digits, number + 1, letters, string, rec);
            string.deleteCharAt(string.length() - 1);
        }
    }

    public String getChars(char ch){
        switch (ch){
            case '0':
                return "0";
            case '1':
                return "1";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "Invalid character";
        }
    }
}
