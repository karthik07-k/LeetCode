package com.leetcode.array;

public class MaxSubArray {

    public static void main(String[] args) {
        // int[] arr = {2, 3, 1, -1, 8, 9};
        // int[] arr = {2, 3, -8, 7, -1, 2, 3};    
        // int[] arr = {-2, -4};
        // int[] arr = {-1};
        // int[] arr = {-2, 6, -3, -10, 0, 2};
        int[] arr = {-1, -3, -10, 0, };
        int n = arr.length;

        int maxSubArray = findMaxSubArray(arr, n);
        System.out.println("The maximum subarray : "+maxSubArray);

        int maxProductSubArray = findMaxProductSubArray(arr, n);
        System.out.println("The max product subarray : "+maxProductSubArray);
    }

    private static int findMaxProductSubArray(int[] arr, int n) {
        //Two pointer approach - Kaden's algorithm

        /**
         * i -> left to right
         * j -> right to left
         * if left = 0 then left =1
         * if right = 0 then right = 1
         * 
         */

         int maxProduct = Integer.MIN_VALUE;

         int left = 1;
         int right = 1;

         for(int i=0; i<n; i++){

            if(left == 0) left = 1;
            if(right == 0) right = 1;

            left *= arr[i];

            left = Math.max(left, arr[i]);

            int j = n-i-1;

            right *= arr[j];

            right = Math.max(right, arr[j]);

            maxProduct = Math.max(maxProduct, Math.max(left, right));

         }

         return maxProduct;
    }

    private static int findMaxSubArray(int[] arr, int n) {
        // Kaden's algorithm 
        /**
         * Time complexity O(n)
         * Space complexity O(1)
         */
        if (arr.length == 1) {
            return arr[0];
        }
         int max = arr[0];

         int currMax = arr[0];

         for(int i=0; i<n; i++){

            currMax = Math.max(currMax+arr[i], arr[i]);

            max = Math.max(currMax, max);
         }

         return max;
    }

}
