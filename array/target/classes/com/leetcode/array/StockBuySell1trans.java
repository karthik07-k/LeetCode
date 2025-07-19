package com.leetcode.array;

public class StockBuySell1trans {

    //Buy stock and sell 1 transaction is allowed

    public static void main(String[] args) {
        // int[] arr = {7, 10, 1, 3, 6, 9, 2, 11, 20};
        // int[] arr = {2, 1, 2, 0, 1}; // Output: 1 (buy at 0, sell at 1)
        // int[] arr = {1, 3, 6, 9, 11};
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4}; // Output: 4 (buy at 0, sell at 4)
        //bruteforce algorithm
        //O(n^2) and O(1)

        int profit = findMaxProfitofBuyAndSellStocks(arr);
        System.out.println("Maximum profit bruteforce : "+profit);
        int n = arr.length;
        int profit1 = findMaxProfitofBuyAndSellStocks(arr, n);
        System.out.println("Maximum profite efficient " +profit1);
        int profit2 =  findMaxProfitofBuyAndSellStocks1(arr, n);
        System.out.println("Maximum profit : "+profit2);
    }

    private static int findMaxProfitofBuyAndSellStocks(int[] arr, int n) {
       int minSoFar = arr[0];
       int max = 0;
       for(int i=1; i < arr.length; i++){
        minSoFar = Math.min(minSoFar, arr[i]);

        max = Math.max(max, arr[i]-minSoFar);
       }

       return max;
    }

    private static int findMaxProfitofBuyAndSellStocks1(int[] prices, int n){
        int max = 0;
        int profit = 0;
        // 7, 10, 1, 3, 6, 9, 2
        for(int i=0; i < n-1; i++){
            if(prices[i] < prices[i+1]){
                max = max + prices[i+1]-prices[i];

                if(max > profit){
                    profit =  max;
                }
            }
            else if(prices[i] > prices[i+1]){
                max = 0;
            }
        }

        return profit;
    }

    private static int findMaxProfitofBuyAndSellStocks(int[] prices) {
        int max = 0;
        //outer loop to decide the day to buy
        for(int i=0; i < prices.length-1; i++){
            //inner loop to decide when to sell the stock
            for(int j=i+1; j < prices.length; j++){
                max = Math.max(max, prices[j]-prices[i]);
            }
        }

        return max;
    }

}
