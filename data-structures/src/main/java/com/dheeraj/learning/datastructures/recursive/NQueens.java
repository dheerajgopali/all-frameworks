package com.dheeraj.learning.datastructures.recursive;

/**
 * Created by dgopali on 10/31/2015.
 */
public class NQueens {
    static int[][] array;
    int n;
    public static void main(String[] args) {
        NQueens nq = new NQueens();
        for(int i = 1;i<10;i++)
            if(!nq.nQueens(i))
                System.out.println(i+" queens wont fit in "+i+"x"+i+" board");
    }

    public boolean nQueens(int size){
        array = new int[size][size];
        n = size;
        //displayBoard(array);
        System.out.println();
        boolean result = setNQueens(0);
        displayBoard(array);

        return result;
    }

    public boolean setNQueens(int col){
        if(col==n){
            return true;
        }
        for(int i=0;i<n;i++){
            if(dontClash(i,col)){
                array[i][col]=1;
                boolean result = setNQueens(col+1);
                if(result)
                    return true;
                else
                    array[i][col]=0;
            }
        }
        return false;
    }

    public boolean dontClash(int row, int col){
        if(col==0)
            return true;
        //Check same row towards left
        for(int i = 0 ; i<col;i++){
            if(array[row][i]==1){
                return false;
            }
        }
        //Check diagonal top
        for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(array[i][j]==1){
                return false;
            }
        }
        //Check diagonal down
        for(int i=row,j=col;i<n&&j>=0;i++,j--){
            if(array[i][j]==1){
                return false;
            }
        }
        return true;
    }

    public void displayBoard(int[][] array){
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
