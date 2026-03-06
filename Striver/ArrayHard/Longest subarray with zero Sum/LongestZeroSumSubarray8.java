import java.util.HashMap;
import java.util.Map;

public class LongestZeroSumSubarray8 {

    /**
     * Finds the length of the longest subarray with sum = 0.
     *
     * @param nums The input array of integers.
     * @return The length of the longest subarray with zero sum.
     * 
     * Time Complexity: O(n) - We traverse the array once, and each lookup and insertion in the HashMap takes O(1) on average.
     * Space Complexity: O(n) - In the worst case, we might store all prefix sums in the HashMap if all elements are unique and non-zero.
     */
    public int longestZeroSumSubarray(int[] nums) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();  // Stores first index of each prefix sum
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // Case 1: subarray from 0 to i has sum = 0
            if (sum == 0) {
                maxLen = i + 1;
            }

            // Case 2: prefix sum seen before → subarray between indices has sum = 0
            if (prefixSumMap.containsKey(sum)) {
                int prevIndex = prefixSumMap.get(sum);

                // Update max length if this subarray is longer than previously found at this prefix sum
                // The length of the subarray is (i - prevIndex) because the sum from index (prevIndex + 1) to i is zero.
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store first occurrence of this prefix sum
                prefixSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestZeroSumSubarray8 solution = new LongestZeroSumSubarray8();

        // Test cases
        System.out.println(solution.longestZeroSumSubarray(new int[]{1, 2, -3, 3, -1, -2, 4})); // Output: 6 (subarray [2, -3, 3, -1, -2])
        System.out.println(solution.longestZeroSumSubarray(new int[]{1, 2, -2, 4, -4}));        // Output: 4 (subarray [2, -2, 4, -4])
        System.out.println(solution.longestZeroSumSubarray(new int[]{1, 2, 3}));               // Output: 0 (no subarray with sum = 0)
        System.out.println(solution.longestZeroSumSubarray(new int[]{0, 0, 0, 0}));            // Output: 4 (entire array has sum = 0)
    }
}
