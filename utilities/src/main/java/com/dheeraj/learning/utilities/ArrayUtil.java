package com.dheeraj.learning.utilities;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/17/2015.
 */
public class ArrayUtil {
    public static void main(String[] args) {
        //System.out.println(buildArray("1,2,3,4,5,6,7,8,9", 3, 3));
        //System.out.println(buildArray("This,is,an,example,of,text,justification."));
        displayArray(buildArray("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0",5));
    }

    public static ArrayList<ArrayList<Integer>> buildArrayList(String str, int m, int n){
        String[] strList = str.split(",");
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(strList.length != m*n){
            return null;
        }
        int k=0;
        for(int i=0;i<m;i++){
            ArrayList<Integer> eachRow = new ArrayList<Integer>();
            for(int j=0;j<n;j++){
                eachRow.add(Integer.parseInt(strList[k++]));
            }
            list.add(eachRow);
        }
        return list;
    }

    public static String[][] buildArray(String str, int m){
        String[] strList = str.split(",");
        String[][] resArray = new String[m][m];
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(strList.length != m*m){
            return null;
        }
        int k=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                resArray[i][j] = strList[k++];
            }
        }
        return resArray;
    }

    public static ArrayList<String> buildArray(String str){
        String[] strList = str.split(",");
        ArrayList<String> list = new ArrayList<String>();
        int k=0;
        for(int i=0;i<strList.length;i++){
            list.add(strList[i]);
        }
        return list;
    }

    public static void displayArray(ArrayList<ArrayList<Integer>> list){
        for(ArrayList<Integer> eachRow : list){
            System.out.print("[");
            for(Integer integer : eachRow){
                System.out.print(integer + " ");
            }
            System.out.print("]\n");
        }
    }

    public static void displayArrayString(ArrayList<ArrayList<String>> list){
        for(ArrayList<String> eachRow : list){
            System.out.print("[");
            for(String str : eachRow){
                System.out.print(str + " ");
            }
            System.out.print("]\n");
        }
    }

    public static void displayArray(String[][] array){
        int noOfRows = array.length;
        for(int i=0;i<noOfRows;i++){
            System.out.print("[");
            int noOfCols = array[i].length;
            for(int j=0;j<noOfCols;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }

}
