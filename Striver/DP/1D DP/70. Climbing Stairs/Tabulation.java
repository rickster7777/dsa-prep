

public class Tabulation {

    public int climbStairs(int n) {

        // Base case:
        // If there is only 1 step → only 1 way
        // If there are 2 steps → 2 ways (1+1 or 2)
        if (n <= 2) return n;

        // Create DP array where:
        // dp[i] represents number of ways to reach step i
        int[] dp = new int[n + 1];

        // Initialize base cases
        dp[1] = 1;  // 1 way to reach step 1
        dp[2] = 2;  // 2 ways to reach step 2

        // Build solution from bottom (small steps) to top (n)
        for (int i = 3; i <= n; i++) {

            // To reach step i:
            // - You can come from step i-1 (1 step jump)
            // - You can come from step i-2 (2 step jump)
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Final answer stored at dp[n]
        return dp[n];
    }
}


/*
🔎 Time & Space Complexity
Time Complexity: O(n)
→ We loop from 3 to n once.

Space Complexity: O(n)
→ We store n values in dp array.

*/