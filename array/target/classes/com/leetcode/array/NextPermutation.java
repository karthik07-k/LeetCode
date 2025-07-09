package com.leetcode.array;

public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};
        int n =  arr.length;
        findNextPermutation(arr, n);

        //print the array
        for(int num : arr){
            System.out.print(num+", ");
        }
    }

    private static void findNextPermutation(int[] arr, int n) {
        
        //Step1 : finding the first decreasing element from right
        // if(i>=0) then below steps 2,3
        //Step2 : find the element just larger than this arr[i]
        //Step3 : swap arr[i] and arr[j]
        //Step4 : reverse the array elements from next ith element i.e., i+1, n-1

        //step1
        int i = n-2;
        while(i >= 0 && arr[i] >= arr[i+1]){
            i--;
        }

        //Step 2,3
        if(i >=0 ){
            int j = n-1;
            //step2
            while(arr[j] <= arr[i]){
                j--;
            }

            //step3
            swap(arr, i, j);
        }
        //step 4
        reverse(arr, i+1, n-1);
    }

    private static void reverse(int[] arr, int i, int j) {
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
