package com.dheeraj.learning.datastructures.recursive;

import com.dheeraj.learning.utilities.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by dgopali on 10/31/2015.
 */
public class NQueensString {


    public static void main(String[] args) {
        NQueensString nq = new NQueensString();
        ArrayUtil.displayArrayString(nq.solveNQueens(1));
    }

    char[][] array;
    int n;
    ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

    public ArrayList<ArrayList<String>> solveNQueens(int size) {
        array = new char[size][size];
        n = size;
        System.out.println();
        initialize(array);
        setNQueens(0);

        return list;
    }

    public int setNQueens(int col) {
        if (col == n) {
            addCharArrayToList(list);
            return 1;
        }
        for (int i = 0; i < n; i++) {
            if (dontClash(i, col)) {
                array[i][col] = 'Q';
                int result = setNQueens(col + 1);
                if (result != -1) {
                    array[i][col] = '.';
                }
                else
                    array[i][col] = '.';
            }
        }
        return -1;
    }

    public boolean dontClash(int row, int col) {
        if (col == 0)
            return true;
        //Check same row towards left
        for (int i = 0; i < col; i++) {
            if (array[row][i] == 'Q') {
                return false;
            }
        }
        //Check diagonal top
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (array[i][j] == 'Q') {
                return false;
            }
        }
        //Check diagonal down
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (array[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public void addCharArrayToList(ArrayList<ArrayList<String>> list) {
        ArrayList<String> tempList = new ArrayList<String>();
        int noOfRows = array.length;
        for (int i = 0; i < noOfRows; i++) {
            int noOfCols = array[i].length;
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < noOfCols; j++) {
                temp.append(array[i][j]);
            }
            tempList.add(temp.toString());
        }
        list.add(tempList);
    }

    public void initialize(char[][] chArray) {
        int noOfRows = chArray.length;
        for (int i = 0; i < noOfRows; i++) {
            int noOfCols = chArray[i].length;
            for (int j = 0; j < noOfCols; j++) {
                chArray[i][j] = '.';
            }
        }
    }

    public void displayBoard(char[][] array) {
        int noOfRows = array.length;
        for (int i = 0; i < noOfRows; i++) {
            System.out.print("[");
            int noOfCols = array[i].length;
            for (int j = 0; j < noOfCols; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.print("]\n");
        }
    }
}
