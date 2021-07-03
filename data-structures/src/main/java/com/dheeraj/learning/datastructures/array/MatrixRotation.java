package com.dheeraj.learning.datastructures.array;

public class MatrixRotation {

    public static void main(String[] args) {
        MatrixRotation matrixRotation = new MatrixRotation();
        int[][] arr = { {1,2,3,4},
                        {14,15,16,5},
                        {13,20,17,6},
                        {12,19,18,7},
                        {11,10,9,8}};
        matrixRotation.print(arr);
        matrixRotation.antiClockRotate(arr);
        System.out.println();
        matrixRotation.print(arr);
        /*matrixRotation.rotate(arr);
        System.out.println();
        matrixRotation.print(arr);*/
    }

    //ClockWise Rotation
    public void rotate(int[][] arr) {
        int row=0;
        int col=0;
        int noOfRows = arr.length;
        int noOfCols = arr[0].length;
        int maxRows = noOfRows-1;
        int maxCols = noOfCols-1;

        int curr;
        while(row < noOfRows/2 && col < noOfCols/2) {
            int prev = arr[row+1][col];
            //Top row
            for(int i=col;i<=maxCols;i++) {
                curr = arr[row][i];
                arr[row][i] = prev;
                prev = curr;
            }

            //Set Right row
            for(int i=row+1;i<=maxRows;i++) {
                curr = arr[i][maxCols];
                arr[i][maxCols] = prev;
                prev = curr;
            }

            //Set Bottom row
            for(int i=maxCols-1;i>=col;i--) {
                curr = arr[maxRows][i];
                arr[maxRows][i] = prev;
                prev = curr;
            }

            //Set Left row
            for(int i=maxRows-1;i>row;i--) {
                curr = arr[i][col];
                arr[i][col] = prev;
                prev = curr;
            }

            row++;
            col++;
            maxRows--;
            maxCols--;
        }
    }

    public void print(int[][] arr) {
        for (int[] row :
                arr) {
            for (int val :
                    row) {
                System.out.print(val+"\t");
            }
            System.out.println();
        }
    }

    //Anti ClockWise Rotation
    public void antiClockRotate(int[][] arr) {
        int row=0;
        int col=0;
        int noOfRows = arr.length;
        int noOfCols = arr[0].length;
        int maxRows = noOfRows-1;
        int maxCols = noOfCols-1;

        int curr;
        while(row < noOfRows/2 && col < noOfCols/2) {
            int prev = arr[row][col+1];
            //Left col
            for(int i=row;i<=maxRows;i++) {
                curr = arr[i][col];
                arr[i][col] = prev;
                prev = curr;
            }

            //Set Bottom row
            for(int i=col+1;i<=maxCols;i++) {
                curr = arr[maxRows][i];
                arr[maxRows][i] = prev;
                prev = curr;
            }

            //Set Right Col
            for(int i=maxRows-1;i>=row;i--) {
                curr = arr[i][maxCols];
                arr[i][maxCols] = prev;
                prev = curr;
            }

            //Set Top row
            for(int i=maxCols-1;i>col;i--) {
                curr = arr[row][i];
                arr[row][i] = prev;
                prev = curr;
            }

            row++;
            col++;
            maxRows--;
            maxCols--;
        }
    }
}
