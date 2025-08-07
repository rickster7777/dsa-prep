public class Solution {
    /**
     * You are given an array nums of non-negative integers and an integer k.
     * An array is called special if the bitwise OR of all of its elements is at least k.
     * Return the length of the shortest special non-empty subarray of nums, or return -1 if no
     * special subarray exists.
     *
     * Steps:
     * 1. Initialize minLen to track the shortest valid subarray length.
     * 2. Iterate over all possible starting indices (i) for subarrays.
     * 3. For each start index, expand the subarray to the right (j) and compute the bitwise OR.
     * 4. If the OR is at least k, update minLen and break (no need to check longer subarrays from i).
     * 5. After checking all possibilities, return minLen if found, else return -1.
     *
     * @param nums the input array of non-negative integers
     * @param k the target OR value
     * @return the length of the shortest special subarray, or -1 if none exists
     */
    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE; // Step 1: Track shortest valid subarray

        // Step 2: Try every possible starting index
        for (int i = 0; i < n; i++) {
            int currentOr = 0;

            // Step 3: Expand subarray to the right and compute OR
            for (int j = i; j < n; j++) {
                currentOr |= nums[j];

                // Step 4: If OR >= k, update minLen and break
                if (currentOr >= k) {
                    // minLen = Math.min(minLen, j - i + 1);
                    minLen = j - i + 1;
                    break; // No need to check longer subarrays starting at i
                }
            }
        }

        // Step 5: Return result
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3};
        int k1 = 2;
        System.out.println("Output: " + minimumSubarrayLength(nums1, k1)); // Output: 1

        // Example 2
        int[] nums2 = {2, 1, 8};
        int k2 = 10;
        System.out.println("Output: " + minimumSubarrayLength(nums2, k2)); // Output: 3
    }
}