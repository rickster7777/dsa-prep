
public class Solution {
    /**
     * House Robber problem (LeetCode 198).
     * <p>
     * Given an array of non-negative integers representing the amount of money
     * of each house, determine the maximum amount of money you can rob
     * tonight without alerting the police. Adjacent houses cannot be robbed
     * consecutively.
     *
     * This implementation uses a **dynamic programming** approach with
     * bottom-up tabulation. We build up a `dp` array where `dp[i]` represents
     * the maximum amount that can be robbed from houses `0..i`. At each step
     * we choose to either skip the current house (take `dp[i-1]`) or rob it
     * and add its value to `dp[i-2]` (since the previous house cannot be
     * robbed). The answer is stored in `dp[n-1]`.
     *
     * Time complexity: O(n)
     * Space complexity: O(n) (can be optimized to O(1) by keeping only two
     * variables instead of the full array).
     *
     * @param nums array of house values
     * @return maximum amount that can be robbed
     */
    public static int rob(int[] nums) {

        int n = nums.length;

        // edge cases
        if (n == 0)
            return 0;            // no houses

        if (n == 1)
            return nums[0];      // only one house

        // dp[i] will hold the maximum loot up to house i
        int[] dp = new int[n + 1];

        // base initialization
        dp[0] = nums[0];
        // either rob house 1 or house 0 (whichever is larger)
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // either we skip current house i and keep dp[i-1],
            // or we rob house i and add its value to dp[i-2]
            int exc = dp[i - 1];
            int inc = dp[i - 2] + nums[i];

            dp[i] = Math.max(exc, inc);
        }

        // the answer for n houses is at index n-1
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(rob(nums));

        int[] nums1 = { 1, 2, 3, 1 };
        System.out.println(rob(nums1));
    }
}
