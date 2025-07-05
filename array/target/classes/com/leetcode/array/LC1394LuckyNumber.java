package com.leetcode.array;

public class LC1394LuckyNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4 };

        int[] freq = new int[501];

        for (int num : arr) {
            freq[num]++;
        }
        int luckyNumber = findLuckyNumber(freq);
        System.out.println("Lucky Number is : "+luckyNumber);
    }

    private static int findLuckyNumber(int[] freq) {
        
    for(int i=500; i>=1; i--){
        if(freq[i] == i){
            return i;
        }
    }
    return -1;
    }
}