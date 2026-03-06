/*
We observed in the tabulation approach that to compute dp[i], we only need the last two values: dp[i-1] and dp[i-2]. Hence, instead of storing the entire DP array, 
we can optimize the space by keeping just two variables to track these states.

Approach:

Initialize two variables:
    prev → represents dp[i-1].
    prev2 → represents dp[i-2].


Iterate from i = 1 to n-1:
    Compute the cost of Jump One: prev + abs(height[i] - height[i-1]).
    If i > 1, compute Jump Two: prev2 + abs(height[i] - height[i-2]).
    Take the minimum of the two.

Update prev2 and prev accordingly after each iteration.

At the end, prev holds the minimum cost to reach the last stone.

Time Complexity: O(n), since we iterate through the stones once.
Space Complexity: O(1), because we only store two variables instead of an entire DP array.

*/
public class Optimize {
    // Computes minimum energy to reach the last stone using O(1) space
    public static int frogJump(int[] height) {
        // Handle empty input
        if (height == null || height.length == 0) return 0;

        // Fetch number of stones
        int n = height.length;

        // Handle single stone case
        if (n == 1) return 0;

        // Initialize the cost to reach i-1 (prev) and i-2 (prev2)
        int prev = 0;
        int prev2 = 0;

        // Iterate through stones from index 1 to n-1
        for (int i = 1; i < n; i++) {
            // Initialize jumpTwo with large value
            int jumpTwo = Integer.MAX_VALUE;

            // Compute cost for jumping from i-1
            int jumpOne = prev + Math.abs(height[i] - height[i - 1]);

            // If possible, compute cost for jumping from i-2
            if (i > 1) {
                jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);
            }

            // Determine minimal cost to reach current stone
            int cur_i = Math.min(jumpOne, jumpTwo);

            // Shift window: update prev2 and prev
            prev2 = prev;
            prev = cur_i;
        }

        // Return minimal cost to reach last stone
        return prev;
    }

     public static void main(String[] args) {
        // Define the heights array
        int[] height = {30, 10, 60, 10, 60, 50};

        // Compute and print the minimum energy
        System.out.println(frogJump(height)); // Expected: 40
    }
}
