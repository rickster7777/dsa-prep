import java.util.HashMap;
import java.util.Map;

/**
 * Solution for: Find the longest subarray with sum equal to k
 *
 * Approach: Prefix Sum with HashMap
 * - Instead of counting subarrays (like in Solution.java), find the LENGTH of
 * longest subarray
 * - Store the FIRST occurrence index of each prefix sum
 * - When we find (sum - k), calculate the length of subarray: current_index -
 * first_occurrence_index
 *
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap stores unique prefix sums
 *
 * Sample Input/Output:
 * Input: nums = [1, 1, 1], k = 2
 * Output: 2 (subarray [1, 1] has length 2)
 *
 * Input: nums = [1, 2, 3], k = 3
 * Output: 2 (subarray [1, 2] has length 2)
 *
 * Input: nums = [-1, 1, 0], k = 0
 * Output: 3 (entire array sums to 0)
 */
public class Solution1 {
    public int longestSubarray(int[] nums, int k) {
        // HashMap to store the FIRST occurrence index of each prefix sum
        // Key: prefix sum,
        // Value: index where it first occurred
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: prefix sum of 0 exists at index -1 (before array starts)
        // This handles subarrays starting from index 0
        map.put(0, -1);

        int sum = 0; // Running cumulative sum
        int maxLen = 0; // Maximum length of subarray found so far

        // Iterate through each element and maintain running sum
        for (int i = 0; i < nums.length; i++) {
            // Add current element to the cumulative sum
            sum += nums[i];

            /**
             * KEY LOGIC: If (sum - k) exists in map, we found a valid subarray
             * 
             * Why? Because if we had prefix sum (sum - k) at some earlier index j,
             * then the subarray from (j+1) to current index i has sum = sum - (sum - k) = k
             * 
             * Example: nums = [1, 2, 3, -2], k = 3
             * At i=2: sum=6, (sum-k)=3, which was seen at index 1
             * Subarray from index 2 to 2 = [3], length = 2-1 = 1? No wait...
             * Actually subarray from index (1+1) to 2 = [3], sum = 3 ✓
             * 
             * Length calculation: current_index - first_occurrence_index_of_(sum-k)
             */
            if (map.containsKey(sum - k)) {
                // Calculate length of subarray with sum = k
                int subarrayLength = i - map.get(sum - k);

                // Update maxLen if this subarray is longer
                maxLen = Math.max(maxLen, subarrayLength);
            }

            /**
             * Store the FIRST occurrence of this prefix sum
             * putIfAbsent ensures we keep the earliest index of each sum
             * (because we want maximum length, earlier occurrence = longer subarray)
             */
            map.putIfAbsent(sum, i);
        }

        // Return length of longest subarray with sum = k
        return maxLen;
    }

    // Test cases
    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        // Test case 1: Simple consecutive 1s
        int[] nums1 = { 1, 1, 1 };
        int k1 = 2;
        System.out.println("Input: nums = [1,1,1], k = 2");
        System.out.println("Output: " + sol.longestSubarray(nums1, k1));
        System.out.println("Expected: 2 (subarray [1,1])\n");

        // Test case 2: Mixed values
        int[] nums2 = { 1, 2, 3 };
        int k2 = 3;
        System.out.println("Input: nums = [1,2,3], k = 3");
        System.out.println("Output: " + sol.longestSubarray(nums2, k2));
        System.out.println("Expected: 2 (subarray [1,2])\n");

        // Test case 3: Contains negative numbers and sum to 0
        int[] nums3 = { -1, 1, 0 };
        int k3 = 0;
        System.out.println("Input: nums = [-1,1,0], k = 0");
        System.out.println("Output: " + sol.longestSubarray(nums3, k3));
        System.out.println("Expected: 3 (entire array)\n");

        // Test case 4: Multiple subarrays, need to find longest
        int[] nums4 = { 1, -1, 5, -2, 2 };
        int k4 = 3;
        System.out.println("Input: nums = [1,-1,5,-2,2], k = 3");
        System.out.println("Output: " + sol.longestSubarray(nums4, k4));
        System.out.println("Expected: 4 (subarray [1,-1,5,-2] or [-1,5,-2,2])");
    }
}