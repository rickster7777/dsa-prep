/*
Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
Example 2:

Input: nums = [1], target = 1
Output: 1
*/
class Solution {
    /**
     * Given an array of integers and a target value, count the number of ways
     * to assign a '+' or '-' sign to each element such that the resulting
     * expression evaluates to the target. This is the classic "Target Sum"
     * problem (LeetCode 494) which can be converted into a subset sum problem.
     *
     * @param nums   the input array of non-negative integers
     * @param target the desired result after assigning signs
     * @return the number of distinct assignments of '+'/'-' that yield target
     */
    public static int findTargetSumWays(int[] nums, int target) {
        // First compute the sum of all numbers in the array. We'll need this
        // to determine if the target is even reachable and to convert the
        // problem into an equivalent subset-sum formulation.
        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        // If the absolute value of target is greater than the total sum, it's
        // impossible to reach the target by adding/subtracting the numbers.
        if (Math.abs(target) > totalSum)
            return 0;

        // The transformation we use is:
        // Let P be the set of numbers assigned '+', and N the set assigned '-'.
        // We want sum(P) - sum(N) = target.
        // Since sum(P) + sum(N) = totalSum, adding the equations gives
        // 2 * sum(P) = target + totalSum.
        // Thus sum(P) = (target + totalSum) / 2, which must be an integer.
        // If (target + totalSum) is odd, no solution exists.
        if ((target + totalSum) % 2 != 0)
            return 0;

        // The required subset sum we need to count is this value.
        int subsetSum = (target + totalSum) / 2;

        // dp[s] will store the number of ways to reach a sum of 's' using a
        // subset of the numbers seen so far. We initialize dp[0] = 1 because
        // there is exactly one way to reach a sum of 0: choose no elements.
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1;

        // Iterate through each number and update the dp array in reverse order.
        // Reversing the iteration (from subsetSum down to num) ensures that each
        // number is only used once per subset (0/1 knapsack style).
        for (int num : nums) {
            for (int s = subsetSum; s >= num; s--) {
                // For a given target sum s, we can either include 'num' or not.
                // The number of ways to reach s including 'num' is the number of
                // ways to reach s - num before this iteration.
                dp[s] += dp[s - num];
            }
        }

        // After processing all numbers, dp[subsetSum] holds the count of
        // subsets whose elements sum to the desired value, which corresponds
        // to the number of ways to assign signs to hit the original target.
        return dp[subsetSum];
    }

    public static void main(String[] args) {
        // Sample test to verify the implementation.
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }

}