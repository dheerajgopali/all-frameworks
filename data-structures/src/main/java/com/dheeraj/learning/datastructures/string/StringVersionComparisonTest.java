package com.dheeraj.learning.datastructures.string;

/**
 * Created by dgopali on 10/20/2015.
 */
public class StringVersionComparisonTest {
    public static void main(String[] args) {
        StringVersionComparisonTest svct = new StringVersionComparisonTest();
        //System.out.println(svct.removePrecedingZeros("0001"));
        String[] str = "123.145.000".split("\\.");
        //StringUtil.displayStringArray(svct.removeEndingZeros(str));
        System.out.println(svct.compareVersion("1.0000000.00000","1.1"));

    }

    public String[] removeEndingZeros(String str[]){
        int len = str.length;
        int lastIndex=len;
        for(int i=len-1;i>=0;i--){
            String a = str[i];
            int temp=0;
            while(temp < str[i].length() && a.charAt(temp)=='0'){
                temp++;
            }
            if(temp==str[i].length()){
                lastIndex = i;
            }else
                break;
        }
        String[] result = new String[lastIndex];
        for(int i=0;i<lastIndex;i++){
            result[i] = str[i];
        }
        return result;
    }

    public int compareVersion(String a, String b) {
        String[] strA = a.split("\\.");
        String[] strB = b.split("\\.");
        strA = removeEndingZeros(strA);
        strB = removeEndingZeros(strB);
        int lenA=strA.length;
        int lenB=strB.length;
        int noOfLoops = Math.min(lenA,lenB);

        for(int i=0;i<noOfLoops;i++){
            strA[i]=removePrecedingZeros(strA[i]);
            strB[i]=removePrecedingZeros(strB[i]);
            int firstLen = strA[i].length();
            int secLen = strB[i].length();

            if(firstLen== secLen){
                int tempi=0;
                while(tempi<firstLen){
                    char charA = strA[i].charAt(tempi);
                    char charB = strB[i].charAt(tempi);

                    if(charA == charB);
                    else if(charA > charB)
                        return 1;
                    else
                        return -1;
                    tempi++;
                }

            }
            else if(firstLen>secLen)
                return 1;
            else
                return -1;
        }
        if(lenA>lenB) {
            return 1;
        }
        else if(lenA < lenB)
            return -1;
        else
            return 0;
    }

    public String removePrecedingZeros(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        for(int i=0;i<stringBuilder.length();i++){
            if(stringBuilder.charAt(i)!='0')
            {
                break;
            }else{
                stringBuilder.deleteCharAt(i--);
            }
        }
        return stringBuilder.toString();
    }
}
