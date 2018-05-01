package com.dheeraj.learning.datastructures.array;

/**
 * Stock Buy Sell to Maximize Profit
 The cost of a stock on each day is given in an array, find the max profit that you can make by buying and selling in those days.
 For example, if the given array is {100, 180, 260, 310, 40, 535, 695}, the maximum profit can earned by buying on day 0, selling on day 3.
 Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order, then profit cannot be earned at all.
 */
public class StockBuySellToMaximizeProfit {
    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maximizeProfits(arr));
    }

    /**
     * This is the solution I've come up with. This is pretty clean and easy to understand that the one given in Geekforgeeks
     * @param arr
     * @return
     */
    static int maximizeProfits(int[] arr) {
        int n = arr.length;
        int profit = 0;
        boolean buy=true;
        int boughtAt=0;
        int soldAt=0;
        for (int i = 0; i < n-1; i++) {
            if(buy){
                if(arr[i] < arr[i+1]){
                    boughtAt=arr[i];
                    buy=false;
                }
            }else {
                if(arr[i] > arr[i+1] || i+1 == n-1) {
                    soldAt = arr[i];
                    profit += soldAt - boughtAt;
                    buy = true;
                }
            }
        }
        return profit;
    }
}
