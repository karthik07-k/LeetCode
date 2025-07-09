package com.leetcode.array;

import java.sql.Time;

public class StockBuySell {

    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        
        int n = arr.length;

        int profit = findMaxProfitofBuyAndSellStocks(arr, n);

        System.out.println("Maximum profit : "+ profit);

        int profit1 = findMaxProfitofBuyAndSellStocks(arr);

        System.out.println("Maximum profit using accumaltive approach : "+ profit1);
        

// Time Complexity:
// O(n), where n is the length of the prices array.
// The function iterates through the array once.
// Space Complexity:

// O(1).
// Only a constant amount of extra space (res and loop variable) is used, regardless of input size.
// Summary:

// Time: O(n)
// Space: O(1)

    }

    private static int findMaxProfitofBuyAndSellStocks(int[] prices) {

        int res = 0;

        for(int i=1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                res += prices[i] - prices[i-1];
            }
        }

        return res;
        
    }

    private static int findMaxProfitofBuyAndSellStocks(int[] prices, int n) {
        
        //local minima and local maxima approach
        int localMinima = prices[0];
        int localMaxima = prices[0];

        int profit = 0;

        int i = 0;
        while(i < n-1){

            //finding local minima
            while(i < n-1 && prices[i] >= prices[i+1]) { i++; }
            localMinima = prices[i];

            //finding local maxima
            while (i < n-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            localMaxima = prices[i];

            //add current profit
            profit += (localMaxima - localMinima);

        }

        return profit;
    }


}
