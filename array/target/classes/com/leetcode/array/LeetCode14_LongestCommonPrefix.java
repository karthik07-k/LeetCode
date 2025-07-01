package com.leetcode.array;

import java.util.Arrays;

public class LeetCode14_LongestCommonPrefix {

    // Finding the longest common prefix among an array of strings
    // Input: strs = ["flower","flow","flight"]
    // Output: "fl"
    // Approach: Using horizontal scanning to find the common prefix
    // Time Complexity: O(n * m) where n is the number of strings and m is the length of the shortest string
    // Space Complexity: O(1)
    public static void main(String[] args) {
        LeetCode14_LongestCommonPrefix longestCommonPrefix = new LeetCode14_LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        System.out.println("Longest common prefix: " + result);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0]; // Start with the first string as the prefix flower
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) { //flower starts with flower
                // If the current prefix is not a prefix of the current string      
                // Check if the current prefix is not a prefix of the current string 
                prefix = prefix.substring(0, prefix.length() - 1); // Reduce the prefix by one character
                if (prefix.isEmpty()) {
                    return ""; // If the prefix becomes empty, return empty string
                }
            }
        }
        return prefix; // Return the longest common prefix found
    }

    // Alternative approach using vertical scanning
    // This approach checks each character of the strings one by one
    // Time Complexity: O(n * m) where n is the number of strings and m is the length of the shortest string
    public String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder(); // Use StringBuilder for efficient string concatenation
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i); // Take the character from the first string
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return prefix.toString(); // If the character does not match, return the prefix found so far
                }
            }
            prefix.append(currentChar); // Append the character to the prefix
        }
        return prefix.toString(); // Return the longest common prefix found
    }

    // Alternative approach using sorting
    // This approach sorts the array and compares the first and last strings    
    public String longestCommonPrefixSorting(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs); // Sort the array of strings
        String first = strs[0]; // First string after sorting
        String last = strs[strs.length - 1]; // Last string after sorting
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++; // Compare characters until they differ
        }
        return first.substring(0, i); // Return the common prefix found
    }

}
