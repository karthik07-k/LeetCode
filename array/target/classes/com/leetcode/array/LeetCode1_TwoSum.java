package com.leetcode.array;

public class LeetCode1_TwoSum {

    // finding the two sum in an array
    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    // Approach: Using brute force method to find the two sum in an array
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)   
    public static void main(String[] args) {
        LeetCode1_TwoSum twoSum = new LeetCode1_TwoSum();
        int[] result = twoSum.twoSum(twoSum.nums, twoSum.target);
        System.out.println("Indices of the two numbers that add up to target: [" + result[0] + ", " + result[1] + "]");
    }
    int nums[] = {2, 7, 11, 15};
    int target = 9;
    public int[] twoSum(int[] nums, int target){
        int[] arr = new int[2];
        int j = 1;
        while(j < nums.length){
            for(int i=0; i+j < nums.length; i++){
                if(nums[i] + nums[i+j] == target){ // check if the sum of two numbers is equal to target
                    // if yes, store the indices in the array
                    arr[0] = i;
                    arr[1] = i + j;
                    return arr; // return the indices of the two numbers
                }
            }
            j++;
        }
        return arr; // if no solution found, return empty array
    }
}
