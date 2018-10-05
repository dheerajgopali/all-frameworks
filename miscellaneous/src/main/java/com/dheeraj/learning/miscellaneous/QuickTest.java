package com.dheeraj.learning.miscellaneous;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class QuickTest {
    public static void main(String[] args) {
        Random rand = new Random();
        int[][] sudokuArray = new int[4][4];
        //displayArray(sudokuArray);
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                LinkedList<Integer> temp = valuesToConsider(row, col, sudokuArray);
                int loc = rand.nextInt(temp.size());
                sudokuArray[row][col]=temp.get(loc);
            }
            //displayArray(sudokuArray);
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
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

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

        //check 4 element box
        if(row < 2 && col == 1){
            list.remove(new Integer(sudokuArray[0][0]));
            list.remove(new Integer(sudokuArray[0][1]));
            list.remove(new Integer(sudokuArray[1][0]));
            list.remove(new Integer(sudokuArray[1][1]));
        }

        if(row >=2 && col == 1){
            list.remove(new Integer(sudokuArray[2][0]));
            list.remove(new Integer(sudokuArray[2][1]));
            list.remove(new Integer(sudokuArray[3][0]));
            list.remove(new Integer(sudokuArray[3][1]));
        }

        if(row < 2 && col == 3){
            list.remove(new Integer(sudokuArray[0][2]));
            list.remove(new Integer(sudokuArray[0][3]));
            list.remove(new Integer(sudokuArray[1][2]));
            list.remove(new Integer(sudokuArray[1][3]));
        }

        if(row >=2 && col == 3){
            list.remove(new Integer(sudokuArray[2][2]));
            list.remove(new Integer(sudokuArray[2][3]));
            list.remove(new Integer(sudokuArray[3][2]));
            list.remove(new Integer(sudokuArray[3][3]));
        }

        return list;
    }
}
