// same as optiimize.js.

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}

/*
| Rank | Approach                       | Time Complexity | Space Complexity | Verdict                             |
| ---- | ------------------------------ | --------------- | ---------------- | ----------------------------------- |
| 🥇 1 | Iterative / Space-Optimized DP | O(n)            | O(1)             | **BEST – fastest & most efficient** |
| 🥈 2 | Tabulation (Bottom-Up DP)      | O(n)            | O(n)             | Very clear, extra memory            |
| 🥉 3 | Memoization (Top-Down DP)      | O(n)            | O(n) + stack     | Slower than tabulation              |
| ❌ 4  | Naive Recursion                | O(2ⁿ)           | O(n)             | **WORST – avoid**                   |

*/