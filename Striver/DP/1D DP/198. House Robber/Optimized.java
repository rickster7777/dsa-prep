/*
The original rob method already runs in linear time, which is optimal.
However, the space complexity can be improved from O(n) to O(1).

🔧 Space‑Optimized Approach
The DP recurrence only ever uses the two previous states (dp[i-1] and dp[i-2]).
Instead of storing the whole array, keep just two variables and roll them forward.
This doesn’t change the time complexity – still O(n) – but reduces memory usage dramatically.

Replacing 4 lines with 30 lines in [](file:///c%3A/Users/rishav/Desktop/dsa-prep/Striver/DP/198.%20House%20Robber/Solution.java)


```

```
✅ **Yes – we can make it more optimal**

The original `rob` method already runs in linear time, which is optimal.  
However, the **space complexity** can be improved from **O(n)** to **O(1)**.

---

### 🔧 Space‑Optimized Approach

- The DP recurrence only ever uses the two previous states (`dp[i-1]` and `dp[i-2]`).
- Instead of storing the whole array, keep just two variables and roll them forward.
- This doesn’t change the time complexity – still **O(n)** – but reduces memory usage dramatically.

### ✅ Summary

| Aspect         | Original | Optimized |
|----------------|----------|-----------|
| Time           | O(n)     | O(n)      |
| Space          | O(n)     | **O(1)**  |

So while the original DP solution is efficient, the **space‑optimized version** is the “better” solution if memory use matters.
Feel free to call `robOptimized` the same way as `rob` in `main`!
*/

public class Optimized {
    public static int robOptimized(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        int prev2 = nums[0]; // dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]); // dp[i-1]

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
