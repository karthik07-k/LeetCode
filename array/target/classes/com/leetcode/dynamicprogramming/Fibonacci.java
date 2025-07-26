package com.leetcode.dynamicprogramming;

public class Fibonacci {

    static Integer[] memo = new Integer[100];
    public static void main(String[] args) {
        
        int n = 8;
        System.out.println("The BruteForce solution : "+ fib(n));
        System.out.println("The DP Top Down Approach - Memoization : "+fibMemo(n));
        System.out.println("The DP Bottom up Approach - Tabulation : "+fibTab(n));
        System.out.println("The Optimal space approach : "+fibOpt(n));
    }
    private static int fibOpt(int n){

        int prevPrev = 0;
        int prev = 1;
        int curr = 1;

        for(int i = 2; i<=n; i++){
            curr = prev + prevPrev;
            prevPrev = prev;
            prev = curr;
        }

        return curr;

    }
    private static int fibTab(int n) {
        //declaring the dp table to store the computed values in iterative approach - bottom up
        int[] dp = new int[n+1];

        //storing the independent values to dp table
        dp[0] = 0;
        dp[1] = 1;

        //using bottom up approach
        for(int index = 2; index <= n; index++){
            dp[index] = dp[index-1] + dp[index-2];
        }

        return dp[n];

    }

    private static int fibMemo(int n) {
        //declaring the memoization table to store the computed values
        if(memo[n] != null){
            return memo[n];
        }
        //base condition
        if(n <= 1){
            return n;
        }
        //storing the 
        memo[n] = fibMemo(n-1)+fibMemo(n-2);

        return memo[n];

    }

    private static int fib(int n) {
        //using recursion
        if(n <= 1){
            return n;
        }

        return fib(n-1)+fib(n-2);
    }

}
