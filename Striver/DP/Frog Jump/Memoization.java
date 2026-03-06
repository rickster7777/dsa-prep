import java.util.*;


/*
A frog is trying to reach the last stone. From any stone i, it can jump either to stone i-1 or i-2, and the cost of a jump is the absolute difference between the
heights of the stones. To minimize the total cost, we recursively compute the minimum cost to reach each stone, reusing already computed results through memoization.

Approach:
Define a recursive function solve(ind) that returns the minimum cost to reach index ind.
Base case: solve(0) = 0, since starting at the first stone has no cost.

For each index, calculate:
    Jump One: Cost from ind-1 to ind.
    Jump Two: Cost from ind-2 to ind (only if ind > 1).

Take the minimum of both jumps and store it in the DP array for reuse.
Finally, return solve(n-1) as the answer.

Complexity Analysis
Time Complexity: O(n), since each state (index) is computed once and stored in the DP array.
Space Complexity: O(n) for the DP array + O(n) recursion stack, leading to O(n) overall.

*/
public class Memoization {
    // Solve function using recursion with memoization
    // ind -> current index the frog needs to reach
    // height -> array of heights
    // dp -> memo table where dp[i] stores min cost to reach i
    private static int solve(int ind, int[] height, int[] dp) {
        // If at the first stone, cost is 0
        if (ind == 0) return 0;

        // Return memoized result if already computed
        if (dp[ind] != -1) return dp[ind];

        // Initialize jumpTwo with a large value
        int jumpTwo = Integer.MAX_VALUE;

        // Compute cost when jumping from previous stone (ind - 1)
        int jumpOne = solve(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);

        // Compute cost when jumping from two stones back (ind - 2) if possible
        if (ind > 1) {
            jumpTwo = solve(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
        }

        // Memoize and return the minimum of the two choices
        dp[ind] = Math.min(jumpOne, jumpTwo);
        return dp[ind];
    }

    // Helper to handle edge cases and start recursion
    public static int frogJump(int[] height) {
        // Handle empty input
        if (height == null || height.length == 0) return 0;

        // Prepare dp with -1 indicating uncomputed states
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        // Start from the last index
        return solve(n - 1, height, dp);
    }



    public static void main(String[] args) {
        // Define the heights array
        int[] height = {30, 10, 60, 10, 60, 50};

        // Compute and print the minimum energy
        System.out.println(frogJump(height)); // Expected: 40
    }
}


