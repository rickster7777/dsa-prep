import java.util.HashMap;
import java.util.Map;

public class Memoization {

    public int climbStairs(int n) {

        // HashMap to store already computed results
        // Key   -> step number
        // Value -> number of ways to reach that step
        Map<Integer, Integer> map = new HashMap<>();

        // Start recursive computation
        return climbing(n, map);
    }

    public static int climbing(int n, Map<Integer, Integer> map) {

        // Base case:
        // If n == 0 or n == 1
        // There is exactly 1 way to stand still or take one step
        if (n <= 1) {
            return 1;
        }

        // If result is NOT already computed,
        // compute and store it in the map
        if (!map.containsKey(n)) {

            // Recurrence relation:
            // ways(n) = ways(n-1) + ways(n-2)
            int val = climbing(n - 1, map) + climbing(n - 2, map);

            // Store result to avoid recomputation
            map.put(n, val);
        }

        // Return stored result
        return map.get(n);
    }
}


/*
⏱ Time Complexity
✅ Time Complexity: O(n)

Why?
Each value from 0 to n is calculated once.
HashMap lookup is O(1) average.

Total unique subproblems = n.

📦 Space Complexity
✅ Space Complexity: O(n)

Because of:
HashMap storing up to n values → O(n)
Recursion call stack depth → O(n)

So total space:
O(n) + O(n) = O(n)

🎯 Important Improvement
Since 1 <= n <= 45, you don’t actually need a HashMap.
You could use an int[] memo = new int[n + 1];
That would be slightly faster than HashMap.

🔥 Interview Insight

Top-Down (Memoization):
Easier to derive from recurrence
More intuitive for beginners
Uses recursion

Bottom-Up:
More optimized
Avoids recursion overhead
Preferred in production
*/