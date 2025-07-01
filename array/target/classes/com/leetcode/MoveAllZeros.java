package com.leetcode;

public class MoveAllZeros {

    //moving zeros to the end of the array
    // Input: nums = [0,1,0,3,12]
    // Output: [1,3,12,0,0]
    // Approach: Using a temporary array to store non-zero elements and then filling the rest with zeros
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    int nums[] = {0, 1, 0, 3, 12};
    int[] temp = new int[nums.length];
    public static void main(String[] args) {
        MoveAllZeros moveAllZeros = new MoveAllZeros();
        moveAllZeros.moveZeroes(moveAllZeros.nums);
        System.out.print("Array after moving zeros to the end: ");
        for (int num : moveAllZeros.nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        // Alternative approaches
        moveAllZeros.moveZeroesTwoPointers(moveAllZeros.nums);  
        System.out.print("Array after moving zeros using two pointers: ");
        for (int num : moveAllZeros.nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        moveAllZeros.moveZeroesInPlace(moveAllZeros.nums);
        System.out.print("Array after moving zeros using in-place swapping: ");
        for (int num : moveAllZeros.nums) {
            System.out.print(num + " ");
        }
    }
    
    public void moveZeroes(int[] nums){
        int j=0;
        for(int i=0; i < nums.length; i++){
            if (nums[i] != 0) {
                temp[j] = nums[i]; // store non-zero elements in temp array
                j++;
            }
        }
        for(int i = j; i < nums.length; i++){
            temp[i] = 0; // fill the rest of the temp array with zeros
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = temp[i];
        }
    }

    // Alternative approach using two pointers
    // This approach uses a count variable to track the position of non-zero elements
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    int count = 0;
    public void moveZeroesTwoPointers(int[] nums) {
         // Count of non-zero elements
        for(int i=0; i< nums.length;i++){
            if(nums[i] != 0){
                nums[count++] = nums[i]; // Move non-zero elements to the front
            }
        }
        // Fill the remaining positions with zeros
        while(count < nums.length) {
            nums[count++] = 0;
        }
    }

    // Alternative approach using in-place swapping
    // This approach swaps non-zero elements with zeros in place
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void moveZeroesInPlace(int[] nums) {
        int index = 0; // Pointer for the position of the next non-zero element
        for(int i=0; i < nums.length;i++){
            if(nums[i] != 0){
                swap(nums[index],nums[i]);
                index++;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = 0;
        temp = i;
        i = j;
        j = temp;
    }
}
