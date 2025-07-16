package containsDuplicate219;

import java.util.*;
/*
Given an integer array nums and an integer k, return true if there are two 
distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // If the number is already in the set, we found a duplicate within k distance
            if (!window.add(nums[i])) {
                return true;
            }
            // Maintain the sliding window of size k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] testCases = {
                { 1, 2, 1, 1 }, // nums for Example 1
                { 1, 0, 1, 1 } // nums for Example 2
        };
        int[] kValues = { 3, 1 }; // k values for each example
        Solution solution = new Solution();

        for (int i = 0; i < testCases.length; i++) {
            boolean result = solution.containsNearbyDuplicate(testCases[i], kValues[i]);
            System.out.println("Test Case " + (i + 1) + ": " + result);
        }
    }

}

//Same as above using static class
// public class Main {
//     public static void main(String[] args) {
//         int[][] testCases = {
//             {1, 2, 3, 1}, // nums for Example 1
//             {1, 0, 1, 1}  // nums for Example 2
//         };
//         int[] kValues = {3, 1}; // k values for each example

//         for (int i = 0; i < testCases.length; i++) {
//             boolean result = containsNearbyDuplicate(testCases[i], kValues[i]);
//             System.out.println("Test Case " + (i + 1) + ": " + result);
//         }

//     public static boolean containsNearbyDuplicate(int[] nums, int k) {
//         Set<Integer> window = new HashSet<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (!window.add(nums[i])) {
//                 return true;
//             }
//             if (window.size() > k) {
//                 window.remove(nums[i - k]);
//             }
//         }
//         return false;
//     }
// } 
