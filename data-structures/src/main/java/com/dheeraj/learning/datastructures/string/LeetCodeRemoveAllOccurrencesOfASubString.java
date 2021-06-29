package com.dheeraj.learning.datastructures.string;

public class LeetCodeRemoveAllOccurrencesOfASubString {
    public static void main(String[] args) {
        LeetCodeRemoveAllOccurrencesOfASubString obj = new LeetCodeRemoveAllOccurrencesOfASubString();
        System.out.println(obj.removeOccurrences("b", "ctl"));
    }

    public String removeOccurrences(String s, String part) {
        if(part.length() > s.length()) {
            return s;
        }

        boolean sContainsPart = true;
        while(sContainsPart) {
            int i,j;
            for(i=0;i<=s.length()-part.length();i++) {
                for(j=0;j<part.length();j++) {
                    if(part.charAt(j) != s.charAt(i+j)) {
                        sContainsPart=false;
                        break;
                    }
                }
                if(j==part.length()) {
                    sContainsPart = true;
                    s = s.substring(0,i)+s.substring(i+j);
                    break;
                }
            }
            if(s.isEmpty() || s.length() < part.length() || (i==s.length() && !sContainsPart)) {
                break;
            }
        }

        return s;
    }
}
