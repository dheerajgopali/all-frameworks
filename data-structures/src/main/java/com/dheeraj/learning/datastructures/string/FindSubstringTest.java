package com.dheeraj.learning.datastructures.string;

/**
 * Created by dgopali on 10/20/2015.
 */
public class FindSubstringTest {
    public static void main(String[] args) {
        FindSubstringTest fst= new FindSubstringTest();
        System.out.println(fst.strStr("","abcdefghi"));
    }

    public int strStr(final String haystack, final String needle) {
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        if(needleLen == 0 || haystackLen == 0)
            return -1;
        for(int i=0;i<=haystackLen-needleLen;i++){
            int temp=i;
            int needleIndex=0;
            while(temp<haystackLen && needleIndex<needleLen){
                if(needle.charAt(needleIndex)==haystack.charAt(temp)){
                    temp++;
                    needleIndex++;
                }else{
                    break;
                }
            }
            if(needleIndex==needleLen)
                return i;
        }
        return -1;
    }
}
