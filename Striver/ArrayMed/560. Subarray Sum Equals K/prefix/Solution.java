import java.util.HashMap;
import java.util.Map;

/**
 * Solution for LeetCode 560: Subarray Sum Equals K
 * Problem: Find the number of subarrays whose sum equals a given target k.

 * Approach: Prefix Sum with HashMap
 * - Use a HashMap to store the frequency of prefix sums encountered so far
 * - For each element, calculate the running sum
 * - Check if (current_sum - k) exists in the map
 * - If it exists, it means there's a subarray with sum = k
 *
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap can store up to n different prefix sums
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store frequency of prefix sums
        // Key: prefix sum value, Value: number of times it occurred
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: initialize with sum 0 occurring once
        // This handles subarrays starting from index 0
        map.put(0, 1);

        int sum = 0; // Running sum of elements
        int count = 0; // Count of subarrays with sum = k

        // Iterate through each element in the array
        for (int num : nums) {
            // Add current element to running sum
            sum += num;

            /**
             * KEY INSIGHT: If we've seen a prefix sum of (sum - k) before,
             * it means there's a subarray between that prefix and current position
             * whose sum equals k.
             *
             * Example: If sum = 5, k = 2, and we've seen prefix sum 3 before,
             * then the subarray between those positions has sum = 5 - 3 = 2
             */
            if (map.containsKey(sum - k)) {
                // Add the frequency of (sum - k) to count
                // (multiple subarrays might have the same sum)
                count += map.get(sum - k);
            }

            // Update the map with current prefix sum
            // Increment its frequency by 1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Return total count of subarrays with sum = k
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1 (commented out):
        // int[] nums = { 1, 1, 1 };
        // int k = 2;
        // System.out.println(sol.subarraySum(nums, k)); // Output: 2
        // Explanation: [1,1] and [1,1] (indices 0-1 and 1-2)

        // Test case 2:
        int[] nums1 = { 1, 2, 3 };
        int k1 = 3;

        // Output: 2
        // Explanation: [3] and [1,2]
        System.out.println(sol.subarraySum(nums1, k1));
    }
}