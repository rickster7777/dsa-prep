public class Optimized {
    public int climbStairs(int n) {

        // Base case
        if (n <= 2)
            return n;

        // a = ways to reach step 1
        int a = 1;

        // b = ways to reach step 2
        int b = 2;

        // Build up to step n
        for (int i = 3; i <= n; i++) {

            // Current step ways
            int current = a + b;

            // Move window forward
            a = b; // previous becomes second previous
            b = current; // current becomes previous
        }

        return b;
    }
}

/*
🔎 Time & Space Complexity

Time Complexity: O(n)

Space Complexity: O(1)
→ Only 2 variables used.


🧠 Important Interview Insight

This problem is:

A 1D Dynamic Programming

A Fibonacci pattern

A state transition problem

*/