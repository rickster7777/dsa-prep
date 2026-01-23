/*
✅ Key Ideas

Direct multiplication is too slow for large n.
Use divide & conquer to compute power in O(log n) time.
Handle negative powers carefully.
Convert n to long to avoid overflow when n = Integer.MIN_VALUE.

💡 Approach
If n < 0, compute 1 / xⁿ

Recursively:
If n is even → (x²)^(n/2)
If n is odd → x * x^(n-1)
*/

class Solution {
    public double myPow(double x, int n) {
        long N = n; // use long to handle Integer.MIN_VALUE

        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0)
            return 1.0;

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

/*
⏱ Time & Space Complexity
Time: O(log n)
Space: O(log n) (recursion stack)

📌 Example Walkthrough

Input: x = 2.0, n = -2
→ Convert to 1 / (2²)
→ Output: 0.25
*/