
/*
Instead of solving the problem recursively, we can build the solution iteratively. Each stone's minimum cost depends only on the
previous one or two stones. By filling a DP array step by step, we avoid recursion overhead and directly compute the answer.

Approach:
Initialize a DP array of size n, where dp[i] represents the minimum cost to reach stone i.
Set dp[0] = 0 (no cost to start).

Iterate from 1 to n-1:
    Jump One: From i-1 to i.
    Jump Two: From i-2 to i (only if i > 1).

    At each step, store the minimum of the two jumps in dp[i].
The final answer is dp[n-1], the minimum cost to reach the last stone.

Time Complexity: O(n), since we fill the DP array once with at most two computations per index.
Space Complexity: O(n) for the DP array.
*/
import java.util.*;

public class Tabulation {
 // Computes minimum energy to reach last index using bottom-up DP
    public static int frogJump(int[] height) {
        // Handle empty input
        if (height == null || height.length == 0) return 0;

        // Fetch size of the input
        int n = height.length;

        // Create dp array where dp[i] = min energy to reach i
        int[] dp = new int[n];

        // Initialize all values to a large number
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base case: cost to stand on first stone is zero
        dp[0] = 0;

        // Iterate over stones from index 1 to n-1
        for (int ind = 1; ind < n; ind++) {
            // Compute cost for a jump from ind-1
            int jumpOne = dp[ind - 1] + Math.abs(height[ind] - height[ind - 1]);

            // Initialize jumpTwo with large value
            int jumpTwo = Integer.MAX_VALUE;

            // If possible, compute cost for a jump from ind-2
            if (ind > 1) {
                jumpTwo = dp[ind - 2] + Math.abs(height[ind] - height[ind - 2]);
            }

            // Take the minimum of the two options
            dp[ind] = Math.min(jumpOne, jumpTwo);
        }

        // Return min energy to reach last stone
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // Define the heights array
        int[] height = {30, 10, 60, 10, 60, 50};

        // Compute and print the minimum energy
        System.out.println(frogJump(height)); // Expected: 40
    }
}
