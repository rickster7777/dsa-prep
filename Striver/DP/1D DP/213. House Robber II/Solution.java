/*
house robber II

Approach:
The problem is a variation of the classic House Robber problem, but with a circular arrangement of houses. This means that the first and last houses are adjacent, and you cannot rob both of them.
To solve this problem, we can break it down into two separate cases:
1. Rob houses from index 0 to n-2 (excluding the last house).
2. Rob houses from index 1 to n-1 (excluding the first house).
We can then take the maximum of the two cases to get the final answer. This way,
we ensure that we never rob both the first and last houses, thus adhering to the circular constraint.
The `robLinear` method is a helper function that implements the standard House Robber logic for a linear arrangement of houses. It uses two variables to keep track of the maximum loot up to the previous two houses, allowing us to achieve O(1) space complexity.
Time complexity: O(n) for both cases combined.
Space complexity: O(1) due to the use of only a few variables in the `robLinear` method.

*/
public class Solution {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];


        // Case 1: Rob houses from index 0 to n-2
        int maxLoot1 = robLinear(nums, 0, n - 2);

        // Case 2: Rob houses from index 1 to n-1
        int maxLoot2 = robLinear(nums, 1, n - 1);

        // Return the maximum of the two cases
        return Math.max(maxLoot1, maxLoot2);
    }

    public static int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = { 1,2,3,1 };
        System.out.println(rob(nums));

        int[] nums2 = { 2,3,2 };
        System.out.println(rob(nums2));
    }
}
