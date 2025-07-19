package com.leetcode.array;

public class CircularMaxSumArray {

    public static void main(String[] args) {
        
        int[] arr = {8, -8, 9, -9, 10, -11, 12};

        int n = arr.length;

        System.out.println("Circular Max Sum subarray : "+ findCircularMaxSumSubarray(arr, n));
    }

    private static int findCircularMaxSumSubarray(int[] arr, int n) {
        /*
         * Kaden's max sum
         * Kaden's min sum
         * Sum of all the elements
         * 
         * actulSum = Kaden's max
         * circularSum = totalSum - Kaden's min
         * 
         * totalSum == Kaden's min then actualSum
         * 
         * return Max(circularSum, actualSum)
         * 
         */

         int totalSum = 0;
         int currMax = 0;
         int currMin = 0;
         int max = arr[0];
         int min = arr[0];

         for(int i=0; i<n; i++){
            //finding the kaden's max
            currMax = Math.max(currMax+arr[i], arr[i]);
            max = Math.max(max, currMax);

            //finding the kaden's min
            currMin = Math.min(currMin+arr[i], arr[i]);
            min = Math.min(min, arr[i]);

            //finding the sum of all the elements
            totalSum += arr[i];

         }

         //actual sum
         int actualSum = max;

         //finding the circularSum 
         int circularSum = totalSum - min;

         if(min == totalSum){
            return actualSum;
         }

         return Math.max(actualSum, circularSum);
    }

}
