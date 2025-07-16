public class Solution {
    /**
     * You are given an array nums of non-negative integers and an integer k.
     * An array is called special if the bitwise OR of all of its elements is at least k.
     * Return the length of the shortest special non-empty subarray of nums, or return -1 if no
     * special subarray exists.
     *
     * @param nums the input array of non-negative integers
     * @param k the target OR value
     * @return the length of the shortest special subarray, or -1 if none exists
     */
    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currentOr = 0;

            for (int j = i; j < n; j++) {
                currentOr |= nums[j];

                if (currentOr >= k) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // No need to check longer subarrays starting at i
                }
            }
        }

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