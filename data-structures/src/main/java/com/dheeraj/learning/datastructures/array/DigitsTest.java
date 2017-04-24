package com.dheeraj.learning.datastructures.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dgopali on 10/16/2015.
 */
public class DigitsTest {

    public static void main(String[] args) {
        DigitsTest dt = new DigitsTest();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(9);
        list.add(99);
        list.add(999);
        list.add(9999);
        list.add(9998);

        long missingNumber=10;
        Integer B = (int)missingNumber;
        // 999, 9999, 9998
        //System.out.println(dt.largestNumber(list));
        //System.out.println(dt.shiftLeft("abc"));
        //System.out.println(dt.largestNumber2(list));
        System.out.println(dt.largestNumber3(list));
        //System.out.println(dt.largestNumber3(list));
    }

    public long getMissingNumber(boolean[] array){
        long length=array.length;
        for(int i=0;i<length;i++){
            if(!array[i])
                return i;
        }
        return -1;
    }

    /*public String shiftLeft(String s){
        return s.substring(1,s.length());
    }
*/

    private void exchangeNumbers(int i, int j, List<Integer> array) {
        int temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);
    }

    private List<Integer> quickSort(int lowerIndex, int higherIndex, List<Integer> array) {
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            while (isLesser4(array.get(i), pivot)>0) {
                i++;
            }
            while (isLesser4(array.get(j),pivot)<0) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, array);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);
        if (i < higherIndex)
            quickSort(i, higherIndex, array);

        return array;
    }

    public String largestNumber3(final List<Integer> list1){
        ArrayList<Integer> list = new ArrayList<Integer>(list1);
        /*for(int i=0;i<list.size()-1;i++){
            for(int j=i+1;j<list.size();j++){
                if(isLesser3(list.get(i), list.get(j))){
                    swap(i,j,list);
                }
            }
        }*/
        list = (ArrayList<Integer>)quickSort(0, list.size()-1, list);

        int i=0;
        for(i=0;i<list.size();i++){
            if(list.get(i)==0){
                continue;
            }else
                break;
        }
        StringBuffer str = new StringBuffer();
        for(;i<list.size();i++){
            str.append(list.get(i));
        }
        return str.toString();
    }

    public void swap(int i, int j, List<Integer> list){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public int isLesser4(Integer one, Integer two){
        StringBuffer XY = new StringBuffer();
        XY.append(one);
        XY.append(two);

        StringBuffer YX = new StringBuffer();
        YX.append(two);
        YX.append(one);

        return XY.toString().compareTo(YX.toString());
    }

    public boolean isLesser3(Integer one, Integer two){
        StringBuffer XY = new StringBuffer();
        XY.append(one);
        XY.append(two);

        StringBuffer YX = new StringBuffer();
        YX.append(two);
        YX.append(one);

        if(XY.toString().compareTo(YX.toString())<0){
            return true;
        }
        return false;
    }

    /*public String largestNumber2(final List<Integer> a) {
        boolean[] array=new boolean[a.size()];
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<a.size()-1;i++){
            int maxIndex=0;
            for(int k=0;k<a.size();k++){
                if(!array[k]){
                    maxIndex = k;
                    break;
                }
            }
            for(int j=1;j<a.size();j++){
                if(!array[j]){
                    StringBuffer strOne=new StringBuffer();
                    strOne.append(a.get(maxIndex));
                    StringBuffer strTwo=new StringBuffer();
                    strTwo.append(a.get(j));
                    if(isLesser2(strOne, strTwo)){
                        maxIndex = j;
                    }
                }
            }
            array[maxIndex]=true;
            buf.append(a.get(maxIndex));
        }
        //Add the last missing element
        for(int i=0;i<a.size();i++){
            if(!array[i]){
                buf.append(a.get(i));
            }
        }
        //Remove prefixed zeros
        int i=0;
        for(i=0;i<buf.length();i++){
            if(buf.charAt(i)=='0'){
                continue;
            }else
                break;
        }
        return i==buf.length()?0+"":buf.substring(i,buf.length());
    }*/



    /*public boolean isLesser2(StringBuffer strOne, StringBuffer strTwo){
        StringBuffer XY = new StringBuffer();
        XY.append(strOne);
        XY.append(strTwo);

        StringBuffer YX = new StringBuffer();
        YX.append(strTwo);
        YX.append(strOne);

        if(XY.toString().compareTo(YX.toString())<0){
            return true;
        }
        return false;
    }

    public boolean isLesser(StringBuffer strOne, StringBuffer strTwo){
        if(strOne.length()==strTwo.length()){
            for(int i=0;i<strOne.length();i++){
                int tempI=Character.getNumericValue(strOne.charAt(i));
                int tempJ=Character.getNumericValue(strTwo.charAt(i));
                if(tempI<tempJ){
                    return true;
                }else if(tempI>tempJ){
                    break;
                }else if(tempI==tempJ){
                    continue;
                }
            }
            return false;
        }else if(strOne.length()>strTwo.length()){
            int i=0;
            for(;i<strTwo.length();i++){
                int tempI=Character.getNumericValue(strOne.charAt(i));
                int tempJ=Character.getNumericValue(strTwo.charAt(i));
                if(tempI<tempJ){
                    return true;
                }else if(tempI>tempJ){
                    break;
                }else if(tempI==tempJ){
                    continue;
                }
            }
            if(i!=strTwo.length()){
                return false;
            }else{
                return isLesser(new StringBuffer().append(strOne.substring(i, strOne.length())),strTwo);
            }
        }else if(strOne.length()<strTwo.length()){
            int i=0;
            for(;i<strOne.length();i++){
                int tempI=Character.getNumericValue(strOne.charAt(i));
                int tempJ=Character.getNumericValue(strTwo.charAt(i));
                if(tempI<tempJ){
                    return true;
                }else if(tempI>tempJ){
                    break;
                }else if(tempI==tempJ){
                    continue;
                }
            }
            if(i!=strOne.length()){
                return false;
            }else{
                return isLesser(strOne,new StringBuffer().append(strTwo.substring(i, strTwo.length())));
            }
        }
        return true;
    }

    public String largestNumber(final List<Integer> b) {
        ArrayList<Integer> a = new ArrayList<Integer>(b);
        for(int i=0;i<a.size();i++){
            for(int j=i+1;j<a.size();j++){
                //If both are single digits
                if(a.get(i)<=9 && a.get(j)<=9){
                    if(a.get(i)>a.get(j)){
                        swap(i,j,a);
                    }
                }
                //if only i is single digit
                else if (a.get(i)<=9 && a.get(j)>9){
                    int jval=a.get(j);
                    String strj = String.valueOf(jval);

                    for(int tempIndex=0;tempIndex<strj.length();tempIndex++){
                        char cj = strj.charAt(tempIndex);
                        int temp = Character.getNumericValue(cj);
                        if(a.get(i)>temp){
                            swap(i,j,a);
                            break;
                        }else if(a.get(i)<temp){
                            break;
                        }else if(a.get(i)==temp){
                            continue;
                        }
                    }
                }
                //If only j is single digit
                else if(a.get(i)>9 && a.get(j)<=9){
                    int ival=a.get(i);
                    String stri = String.valueOf(ival);

                    for(int tempIndex=0;tempIndex<stri.length();tempIndex++){
                        char ci=stri.charAt(tempIndex);
                        int temp=Character.getNumericValue(ci);
                        if(temp>a.get(j)){
                            swap(i,j,a);
                            break;
                        }else if(temp<a.get(j)){
                            break;
                        }else if(temp==a.get(j)){
                            continue;
                        }
                    }
                    //If last digit of a.get(i) is zero, then we've to swap
                }
                //If both i,j has more than one digit
                else if(a.get(i)>9 && a.get(j)>9){
                    int ival=a.get(i);
                    int jval=a.get(j);
                    String stri=String.valueOf(ival);
                    String strj=String.valueOf(jval);
                    int len = Math.min(stri.length(),strj.length());
                    boolean allcharsequal=true;
                    for(int temp=0;temp<len;temp++){
                        char ci=stri.charAt(temp);
                        char cj=strj.charAt(temp);
                        int tempi=Character.getNumericValue(ci);
                        int tempj=Character.getNumericValue(cj);
                        if(tempi>tempj){
                            allcharsequal=false;
                            swap(i,j,a);
                            break;
                        }else if(tempi < tempj){
                            allcharsequal=false;
                            break;
                        }else if(tempi == tempj){
                            allcharsequal=true;
                        }
                    }
                    if(allcharsequal){
                        if(stri.length()<strj.length()){
                            swap(i,j,a);
                        }
                    }
                }
            }
        }
        return convertListToString(a);
    }

    public String convertListToString(List<Integer> a){
        StringBuffer str=new StringBuffer();
        for(int i=a.size()-1;i>=0;i--){
            str.append(a.get(i));
        }
        String s = str.toString();
        int i=0;
        for(i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                continue;
            }else
                break;
        }
        return i==s.length()?0+"":s.substring(i,s.length());
    }

    public String shiftLeft(String s){
        if(s.length()==1)
            return s;
        else
            return s.substring(1,s.length());
    }

    public void swap(int i, int j, List<Integer> a){
        int temp=a.get(i);
        a.set(i,a.get(j));
        a.set(j,temp);
    }*/
}
