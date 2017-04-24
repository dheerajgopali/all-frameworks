package com.dheeraj.learning.datastructures.string;

/**
 * Created by dgopali on 10/20/2015.
 */
public class FindLastWordTest {
    public static void main(String[] args) {
        FindLastWordTest fswt = new FindLastWordTest();
        System.out.println(fswt.lengthOfLastWord("abd def asdfsaf';'';'"));
    }

    public int lengthOfLastWord(final String a) {
        boolean isFirst = true;
        int startIndex = 0;
        int endIndex = 0;

        for(int i=a.length()-1;i>=0;i--){
            if(a.charAt(i)!=' '){
                if(isFirst){
                    endIndex = i;
                    isFirst = false;
                }
            }else{
                if(!isFirst){
                    startIndex = i+1;
                    break;
                }
            }
        }
        if(isFirst)
            return 0;
        else
            return endIndex - startIndex + 1;
    }
}
