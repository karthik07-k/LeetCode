package com.leetcode.array;

public class StockBuySell {

    public static void main(String[] args) {
        int[] arr = {100, 180, 260, 310, 40, 535, 695};
        
        int n = arr.length;

        int profit = findMaxProfitofBuyAndSellStocks(arr, n);

        System.out.println("Maximum profit : "+ profit);

        int profit1 = findMaxProfitofBuyAndSellStocks(arr);

        System.out.println("Maximum profit using accumaltive approach : "+ profit1);
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

        int res = 0;

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
            res += (localMaxima - localMinima);

        }

        return res;
    }

}
