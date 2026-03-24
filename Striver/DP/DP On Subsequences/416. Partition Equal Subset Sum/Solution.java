/*
input: nums = [1,5,11,5]
output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

input: nums = [1,2,3,5]
output: false
Explanation: The array cannot be partitioned into equal sum subsets.


*/

/*
This problem is a classic 0/1 Knapsack (subset sum) variant.

Goal: Split the array into two subsets with equal sum.

Key Observations

Let total = sum(nums).

If total is odd, equal partition is impossible → return false.

Otherwise, each subset must sum to:

𝑡𝑎𝑟𝑔𝑒𝑡 = 𝑡𝑜𝑡𝑎𝑙 / 2

Now the problem becomes:

Can we pick some numbers whose sum equals target?
That is exactly the subset sum problem.

Approach: Dynamic Programming

Use a boolean DP array:

dp[s] = true → we can form sum s using some elements.

Initialization
dp[0] = true
Transition

For each number num, update DP backwards:

dp[s] = dp[s] OR dp[s - num]

Backwards iteration prevents using the same element multiple times.

Algorithm Steps:

1. Compute total.
2. If total % 2 != 0 → return false.
3. target = total / 2.
4. Create dp[target + 1].
5. Update dp for each number.
6. Return dp[target].

*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums)
            sum += n;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // sum 0 is always possible by taking nothing

        for (int num : nums) // process each number one by one meaning we can only use it once and If I
                             // include this number, what new sums become possible?

        // We try to update all sums that could include num.
        // Why start from target?
        // Because we want to see if we can form larger sums using the current number.
        // Why stop at num?
        // Because:
        // s - num >= 0
        // We cannot access negative indices.

        {
            System.out.println("Processing number: " + num);
            for (int s = target; s >= num; s--) { // If we loop forward, we reuse the same number multiple times.
                dp[s] = dp[s] || dp[s - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = { 1, 5, 11, 5 };
        int[] nums2 = { 1, 2, 3, 5 };

        System.out.println(sol.canPartition(nums1)); // true
        System.out.println(sol.canPartition(nums2)); // false
    }
}