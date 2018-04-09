package com.dheeraj.learning.datastructures;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.

 If x is not a perfect square, return floor(sqrt(x))

 Example :

 Input : 11
 Output : 3
 * Created by dgopali on 10/19/2015.
 */
public class SquareRootTest {
    public static void main(String[] args) {
        System.out.println(SquareRootTest.findSquareRoot(1000000));
        System.out.println(SquareRootTest.sqrt(Integer.MAX_VALUE));
        System.out.println(SquareRootTest.sqrt2(1000000));
        System.out.println(1000000);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(46340*46340);
        System.out.println(46341*46341);
        //TODO Observations
        //Max value of integer that can be multiplied without overflow is 46340
        System.out.println();
    }

    public static int sqrt2(int value) {

            double lo = 1.0;
            double hi = value;

            while( hi - lo > 0.00001)
            {
                double mid = lo + (hi - lo) / 2 ;
                //std::cout << lo << "," << hi << "," << mid << std::endl;
                if( mid * mid - value > 0.00001)    //this is the predictors we are using
                {
                    hi = mid;
                } else {
                    lo = mid;
                }

            }

            return (int)lo;
    }

    /**
     * I've deduced this method. It turns out works perfectly.
     * Algorithm
     * If num == 0 or 1
     *  return number
     *  else
     *      Binary search from 1 to number/2 -- As square root can't be greater than half of the number.
     *          if mid == number/mid (Did integer division here so that I get to compare with the floor value)
     *              found the nearest sqrt and break from loop
     *          else if mid < number/mid
     *              search right side i.e low = mid + 1;
     *          else
     *              search left side i.e high = mid -1 ;
     * @param number
     * @return
     */
    public static int sqrt(int number) {
        int result = 0;
        if(number == 0 || number == 1)
            result = number;
        else{
            int low = 1;
            int high = number/2;
            while(low<=high){
                int mid = (low+high)/2;
                //long tempMid= (long)mid*mid; //Explicitly convert int to long after calculation. Otherwise overflow happens and
                                            // default conversion takes place. Integer will be converted to negative value after
                                            // overflown and then that negative value will be assigned to long.
                if(mid == number/mid) {
                    result = mid;
                    break;
                }
                else if (mid < number/mid) {
                    low = mid + 1;
                    result = mid;
                }
                else
                    high = mid - 1;
            }
        }
        return result;
    }












    /*This method finds out the square root without using
    any built-in functions and displays it */
    public static int findSquareRoot(int number) {

        boolean isPositiveNumber = true;
        double g1;

        //if the number given is a 0
        if (number == 0) {
            System.out.println("Square root of " + number + " = " + 0);
        }

        //Proceeding to find out square root of the number
        double squareRoot = number / 2;
        do {
            g1 = squareRoot;
            squareRoot = (g1 + (number / g1)) / 2;
        } while ((g1 - squareRoot) != 0);

        return (int) squareRoot;
    }
}
