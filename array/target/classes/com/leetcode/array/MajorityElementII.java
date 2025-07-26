package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        //output
        //[5, 6]
        // You are given an array of integer arr[] where each number represents a vote to a candidate. 
        // Return the candidates that have votes greater than one-third of the total votes, 
        // If there's not a majority vote, return an empty array. 

        // Better approach 
        /*
         * 1. find the frequency of the elements using hashmap
         * 2. iterate through entry set check if (count > n/3)
         * 3. check the list size ==  2 and check index 0 is greater than index 1
         * 4. if yes, swap them
         */

        // Optimzed solution
        /*
         * Boyer - Moore's Voting Algorithm - O(n) and Space O(1)
         * 1. Initialize two elements and the counts variables respectively with -1 and 0
         * 2. cnt1 = 0 then element1 = arr[i] and cnt++
         * 3. cnt2 = 0 then element2 = arr[i] and cnt++
         * 4. incrementing the counts based on the occurence, 
         * 5. if not satify above condition, then cnt1--, cnt2--
         * 6. find the frequency 
         * 7. check count > n/3 && element1 != element2
         * 8. check the list size and check index 0 is greater than index 1
         * 9. if yes, swap them
         */
        int n = arr.length;
        List<Integer> result = fidnMajorityElementII(arr, n);

        System.out.println(result);
    }

    private static List<Integer> fidnMajorityElementII(int[] arr, int n) {
        //step1
        int ele1 = -1;
        int ele2 = -1;
        int cnt1 = 0;
        int cnt2 = 0;

        //step2, 3, 4, 5

        for(int num : arr){
            
            if(num == ele1){
                cnt1++;
            }
            else if (num == ele2) {
                cnt2++;
            }
            else if (cnt1 == 0) {
                ele1 = num;
                cnt1++;
            }
            else if(cnt2 == 0){
                ele2 = num;
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        //step 6
        List<Integer> result = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        
        for(int num : arr){
            if(num == ele1) cnt1++;
            if(num == ele2) cnt2++;
        }

        //step 7
        if(cnt1 > n/3) result.add(ele1);
        if(cnt2 > n/3 && ele2 != ele1) result.add(ele2);

        //step 8
        if(result.size() == 2 && result.get(0) > result.get(1)){
            int temp = result.get(0);
            result.set(0, result.get(1));
            result.set(1, temp);
        }

        return result;
    }
    
}
