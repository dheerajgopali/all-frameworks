package com.dheeraj.learning.datastructures.array;

/**
 * Reverse an array without affecting special characters
 Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.

 Examples:

 Input:   str = "a,b$c"
 Output:  str = "c,b$a"
 Note that $ and , are not moved anywhere.
 Only subsequence "abc" is reversed

 Input:   str = "Ab,c,de!$"
 Output:  str = "ed,c,bA!$"
 */
public class ReverseArrayWithSpecialCharacters {
    public static void main(String[] args) {
        String str = "Ab,c,de!$";
        String res = reverseArray(str.toCharArray());
        System.out.println(res);
    }

    public static String reverseArray(char str[]){
        int low = 0;
        int high = str.length-1;
        while(low < high){
            if(!Character.isAlphabetic(str[low])){
                low++;
            }else if(!Character.isAlphabetic(str[high])){
                high--;
            }else{
                char temp = str[low];
                str[low]=str[high];
                str[high]=temp;
                low++;
                high--;
            }
        }
        return new String(str);
    }
}
