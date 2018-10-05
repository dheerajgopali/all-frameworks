package com.dheeraj.learning.miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Sudoku {
    /**
     * I think this has to be a perfect square of another integer.
     */
    public static int SUDOKUSIZE=9;
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] sudokuArray = new int[SUDOKUSIZE][SUDOKUSIZE];
        displayArray(sudokuArray);
        for (int col = 0; col < SUDOKUSIZE; col++) {
            for (int row = 0; row < SUDOKUSIZE; row++) {
                LinkedList<Integer> temp = valuesToConsider(row, col, sudokuArray);
                System.out.println("List size : "+temp.size());
                int loc = rand.nextInt(temp.size());
                System.out.println("List location : "+loc);
                sudokuArray[row][col]=temp.get(loc);
                System.out.println("After each number "+row+", "+col);
                displayArray(sudokuArray);
            }
        }
        System.out.println("After processing");
        displayArray(sudokuArray);
    }

    private static void displayArray(int[][] sudokuArray) {
        for (int i = 0; i < sudokuArray[0].length; i++) {
            for (int j = 0; j < sudokuArray.length; j++) {
                System.out.print(sudokuArray[i][j]+" ");
            }
            System.out.println();
        }
    }

    static LinkedList<Integer> valuesToConsider(int row, int col, int[][] sudokuArray) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <=SUDOKUSIZE ; i++) {
            list.add(i);
        }

        //Check previous rows
        int temp = row-1;
        while(temp >= 0){
            if(sudokuArray[temp][col] != 0)
                list.remove(new Integer(sudokuArray[temp][col]));
            temp--;
        }

        //Check previous columns
        temp = col-1;
        while(temp >= 0) {
            if(sudokuArray[row][temp] != 0)
                list.remove(new Integer(sudokuArray[row][temp]));
            temp--;
        }

        //check 9 element box
        int rowStart = (row/3)*3;
        int colStart = (col/3)*3;
        removeBoxElements(list, rowStart, colStart, col, sudokuArray);
        return list;
    }

    private static void removeBoxElements(LinkedList<Integer> list, int rowStart, int colStart, int col, int[][] sudokuArray) {
        for (int i = colStart; i <= col ; i++) {
            for (int j = rowStart; j < rowStart+3 ; j++) {
                list.remove(new Integer(sudokuArray[j][i]));
            }
        }
    }
}
