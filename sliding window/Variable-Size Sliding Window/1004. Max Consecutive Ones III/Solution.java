/*
 *
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at
 * most k 0's.
 */

class Solution {
    /**
     * Finds the maximum number of consecutive 1's in the array if you can flip at most k 0's.
     * Uses a variable-size sliding window to keep track of the number of zeros in the window.
     * Key steps to remember:
     * 1. Use two pointers (left and right) to define the window.
     * 2. Count zeros in the current window using zeroCount.
     * 3. If zeroCount exceeds k, shrink the window from the left until it is valid.
     * 4. Update maxLen at each step to track the largest valid window.
     * 5. The window always contains at most k zeros (which can be flipped).
     * @param nums the input binary array
     * @param k the maximum number of zeros you can flip
     * @return the length of the longest subarray with at most k zeros flipped
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxLen = 0;
        int zeroCount = 0; // Number of zeros in the current window

        // Expand the window with the right pointer
        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++; // Count zeros in the window
            }

            // Shrink the window from the left if zeroCount exceeds k
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--; // Remove zero from the count
                }
                left++; // Move left pointer forward
            }

            // Update the maximum length found so far
            maxLen = Math.max(maxLen, right - left + 1);
            right++; // Move right pointer forward
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;

        System.out.println(Solution.longestOnes(nums, k)); // Output: 6
    }
}
