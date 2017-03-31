package com.dheeraj.learning.datastructures;

/**
 * Created by dgopali on 10/19/2015.
 */
public class SquareRootTest {
    public static void main(String[] args)
    {
        System.out.println(SquareRootTest.findSquareRoot(11));
    }

    /*This method finds out the square root without using
    any built-in functions and displays it */
    public static int findSquareRoot(int number)
    {

        boolean isPositiveNumber = true;
        double g1;

        //if the number given is a 0
        if(number==0)
        {
            System.out.println("Square root of "+number+" = "+0);
        }

        //Proceeding to find out square root of the number
        double squareRoot = number/2;
        do
        {
            g1=squareRoot;
            squareRoot = (g1 + (number/g1))/2;
        }while((g1-squareRoot)!=0);

        return (int)squareRoot;
    }
}
